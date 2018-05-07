package org.intellij.erlang.psi.impl;

import org.intellij.erlang.ErlangParserDefinition;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.impl.source.tree.PsiCommentImpl;
import com.intellij.psi.tree.IElementType;
import consulo.lang.LanguageVersion;
import consulo.psi.tree.ASTLeafFactory;

public class ErlangASTLeafFactory implements ASTLeafFactory
{
	public static class ErlangCommentImpl extends PsiCommentImpl
	{
		public ErlangCommentImpl(IElementType type, CharSequence text)
		{
			super(type, text);
		}
	}

	@Nonnull
	@Override
	public LeafElement createLeaf(@Nonnull IElementType elementType, @Nonnull LanguageVersion languageVersion, @Nonnull CharSequence charSequence)
	{
		return new ErlangCommentImpl(elementType, charSequence);
	}

	@Override
	public boolean apply(@Nullable IElementType elementType)
	{
		return ErlangParserDefinition.COMMENTS.contains(elementType);
	}
}
