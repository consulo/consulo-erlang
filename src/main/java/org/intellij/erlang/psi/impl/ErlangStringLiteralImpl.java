// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;

import static org.intellij.erlang.ErlangTypes.*;

import javax.annotation.Nonnull;

import org.intellij.erlang.psi.*;
import org.intellij.erlang.ErlangStringLiteralEscaper;

public class ErlangStringLiteralImpl extends ErlangExpressionImpl implements ErlangStringLiteral {

  public ErlangStringLiteralImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitStringLiteral(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public PsiElement getString() {
    return findNotNullChildByType(ERL_STRING);
  }

  public boolean isValidHost() {
    return ErlangPsiImplUtil.isValidHost(this);
  }

  public ErlangStringLiteral updateText(String text) {
    return ErlangPsiImplUtil.updateText(this, text);
  }

  @Nonnull
  public ErlangStringLiteralEscaper createLiteralTextEscaper() {
    return ErlangPsiImplUtil.createLiteralTextEscaper(this);
  }

}
