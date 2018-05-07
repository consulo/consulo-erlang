// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;

import static org.intellij.erlang.ErlangTypes.*;

import javax.annotation.*;

import org.intellij.erlang.psi.*;

public class ErlangBeginEndExpressionImpl extends ErlangExpressionImpl implements ErlangBeginEndExpression {

  public ErlangBeginEndExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitBeginEndExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ErlangBeginEndBody getBeginEndBody() {
    return findChildByClass(ErlangBeginEndBody.class);
  }

  @Override
  @Nonnull
  public PsiElement getBegin() {
    return findNotNullChildByType(ERL_BEGIN);
  }

  @Override
  @Nullable
  public PsiElement getEnd() {
    return findChildByType(ERL_END);
  }

}
