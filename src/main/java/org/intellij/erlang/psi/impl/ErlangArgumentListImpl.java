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

public class ErlangArgumentListImpl extends ErlangCompositeElementImpl implements ErlangArgumentList {

  public ErlangArgumentListImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitArgumentList(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public List<ErlangClauseGuard> getClauseGuardList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ErlangClauseGuard.class);
  }

  @Override
  @Nonnull
  public List<ErlangExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ErlangExpression.class);
  }

  @Override
  @Nonnull
  public PsiElement getParLeft() {
    return findNotNullChildByType(ERL_PAR_LEFT);
  }

  @Override
  @Nullable
  public PsiElement getParRight() {
    return findChildByType(ERL_PAR_RIGHT);
  }

}
