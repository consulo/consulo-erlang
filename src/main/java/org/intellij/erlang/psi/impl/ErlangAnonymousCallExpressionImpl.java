// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;

import javax.annotation.Nonnull;

import org.intellij.erlang.psi.*;

public class ErlangAnonymousCallExpressionImpl extends ErlangExpressionImpl implements ErlangAnonymousCallExpression {

  public ErlangAnonymousCallExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitAnonymousCallExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public ErlangArgumentList getArgumentList() {
    return findNotNullChildByClass(ErlangArgumentList.class);
  }

  @Override
  @Nonnull
  public ErlangExpression getExpression() {
    return findNotNullChildByClass(ErlangExpression.class);
  }

}
