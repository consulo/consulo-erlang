// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;

import static org.intellij.erlang.ErlangTypes.*;

import javax.annotation.*;

import org.intellij.erlang.psi.*;

public class ErlangLcExpressionImpl extends ErlangExpressionImpl implements ErlangLcExpression {

  public ErlangLcExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitLcExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ErlangArgumentDefinition getArgumentDefinition() {
    return findChildByClass(ErlangArgumentDefinition.class);
  }

  @Override
  @Nonnull
  public ErlangExpression getExpression() {
    return findNotNullChildByClass(ErlangExpression.class);
  }

  @Override
  @Nullable
  public PsiElement getOpLtEq() {
    return findChildByType(ERL_OP_LT_EQ);
  }

  @Override
  @Nullable
  public PsiElement getOpLtMinus() {
    return findChildByType(ERL_OP_LT_MINUS);
  }

}
