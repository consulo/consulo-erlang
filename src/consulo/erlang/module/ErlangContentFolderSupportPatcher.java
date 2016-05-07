package consulo.erlang.module;

import java.util.Set;

import org.jetbrains.annotations.NotNull;
import org.mustbe.consulo.roots.ContentFolderSupportPatcher;
import org.mustbe.consulo.roots.ContentFolderTypeProvider;
import org.mustbe.consulo.roots.impl.ProductionContentFolderTypeProvider;
import org.mustbe.consulo.roots.impl.TestContentFolderTypeProvider;
import com.intellij.openapi.roots.ModifiableRootModel;
import consulo.erlang.module.extension.ErlangModuleExtension;

/**
 * @author VISTALL
 * @since 13.02.15
 */
public class ErlangContentFolderSupportPatcher implements ContentFolderSupportPatcher
{
	@Override
	public void patch(@NotNull ModifiableRootModel model, @NotNull Set<ContentFolderTypeProvider> set)
	{
		ErlangModuleExtension extension = model.getExtension(ErlangModuleExtension.class);
		if(extension != null)
		{
			set.add(ProductionContentFolderTypeProvider.getInstance());
			set.add(TestContentFolderTypeProvider.getInstance());
			set.add(ErlangIncludeContentFolderTypeProvider.getInstance());
		}
	}
}
