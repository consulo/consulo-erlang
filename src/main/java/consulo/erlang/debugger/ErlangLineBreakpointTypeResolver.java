package consulo.erlang.debugger;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.Processor;
import com.intellij.xdebugger.XDebuggerUtil;
import com.intellij.xdebugger.breakpoints.XLineBreakpointType;
import consulo.annotation.access.RequiredReadAction;
import consulo.xdebugger.breakpoints.XLineBreakpointTypeResolver;
import org.intellij.erlang.ErlangFileType;
import org.intellij.erlang.ErlangTypes;
import org.intellij.erlang.debugger.xdebug.ErlangLineBreakpointType;
import org.intellij.erlang.psi.*;
import org.intellij.erlang.psi.impl.ErlangPsiImplUtil;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author VISTALL
 * @since 5/8/2016
 */
public class ErlangLineBreakpointTypeResolver implements XLineBreakpointTypeResolver
{
	@Nullable
	@Override
	@RequiredReadAction
	public XLineBreakpointType<?> resolveBreakpointType(@Nonnull Project project, @Nonnull VirtualFile virtualFile, int line)
	{
		if(virtualFile.getFileType() != ErlangFileType.MODULE)
		{
			return null;
		}
		return isLineBreakpointAvailable(virtualFile, line, project) ? ErlangLineBreakpointType.getInstance() : null;
	}


	// it should return true for lines matching "Executable Lines"
	// description at http://www.erlang.org/doc/apps/debugger/debugger_chapter.html
	// and, ideally, it should return false otherwise
	@RequiredReadAction
	private static boolean isLineBreakpointAvailable(VirtualFile file, int line, @Nonnull Project project)
	{
		Document document = FileDocumentManager.getInstance().getDocument(file);
		if(document == null)
		{
			return false;
		}
		LineBreakpointAvailabilityProcessor canPutAtChecker = new LineBreakpointAvailabilityProcessor();
		XDebuggerUtil.getInstance().iterateLine(project, document, line, canPutAtChecker);
		return canPutAtChecker.isLineBreakpointAvailable();
	}

	private static final class LineBreakpointAvailabilityProcessor implements Processor<PsiElement>
	{
		private boolean myIsLineBreakpointAvailable;

		@Override
		@RequiredReadAction
		public boolean process(PsiElement psiElement)
		{
			if(ErlangPsiImplUtil.isWhitespaceOrComment(psiElement) ||
					psiElement.getNode().getElementType() == ErlangTypes.ERL_DOT ||
					psiElement.getNode().getElementType() == ErlangTypes.ERL_ARROW)
			{
				return true;
			}
			@SuppressWarnings("unchecked") ErlangCompositeElement nonExecutableParent = PsiTreeUtil.getParentOfType(psiElement, ErlangGuard.class, ErlangArgumentDefinition.class,
					ErlangAttribute.class, ErlangRecordDefinition.class, ErlangIncludeLib.class, ErlangInclude.class, ErlangMacrosDefinition.class, ErlangTypeDefinition.class);
			if(nonExecutableParent != null)
			{
				return true;
			}
			ErlangClauseBody executableParent = PsiTreeUtil.getParentOfType(psiElement, ErlangClauseBody.class);
			if(executableParent != null)
			{
				myIsLineBreakpointAvailable = true;
				return false;
			}
			return true;
		}

		public boolean isLineBreakpointAvailable()
		{
			return myIsLineBreakpointAvailable;
		}
	}
}
