// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;

import javax.annotation.Nonnull;

import org.intellij.erlang.psi.*;

public class ErlangExpressionImpl extends ErlangCompositeElementImpl implements ErlangExpression {

  public ErlangExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitExpression(this);
    else super.accept(visitor);
  }

}
