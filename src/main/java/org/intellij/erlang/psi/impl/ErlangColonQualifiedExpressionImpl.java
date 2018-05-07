// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import java.util.List;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.erlang.ErlangTypes.*;

import javax.annotation.Nonnull;

import org.intellij.erlang.psi.*;

public class ErlangColonQualifiedExpressionImpl extends ErlangExpressionImpl implements ErlangColonQualifiedExpression {

  public ErlangColonQualifiedExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitColonQualifiedExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public List<ErlangExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ErlangExpression.class);
  }

  @Override
  @Nonnull
  public PsiElement getColon() {
    return findNotNullChildByType(ERL_COLON);
  }

}
