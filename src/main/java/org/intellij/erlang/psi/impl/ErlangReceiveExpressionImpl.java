// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import java.util.List;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.erlang.ErlangTypes.*;

import javax.annotation.*;

import org.intellij.erlang.psi.*;

public class ErlangReceiveExpressionImpl extends ErlangExpressionImpl implements ErlangReceiveExpression {

  public ErlangReceiveExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitReceiveExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ErlangAfterClause getAfterClause() {
    return findChildByClass(ErlangAfterClause.class);
  }

  @Override
  @Nonnull
  public List<ErlangCrClause> getCrClauseList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ErlangCrClause.class);
  }

  @Override
  @Nullable
  public PsiElement getEnd() {
    return findChildByType(ERL_END);
  }

  @Override
  @Nonnull
  public PsiElement getReceive() {
    return findNotNullChildByType(ERL_RECEIVE);
  }

}
