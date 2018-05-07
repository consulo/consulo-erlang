// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;

import javax.annotation.*;

import org.intellij.erlang.psi.*;

public class ErlangRuleClauseImpl extends ErlangCompositeElementImpl implements ErlangRuleClause {

  public ErlangRuleClauseImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitRuleClause(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public ErlangArgumentList getArgumentList() {
    return findNotNullChildByClass(ErlangArgumentList.class);
  }

  @Override
  @Nullable
  public ErlangClauseGuard getClauseGuard() {
    return findChildByClass(ErlangClauseGuard.class);
  }

  @Override
  @Nonnull
  public ErlangQAtom getQAtom() {
    return findNotNullChildByClass(ErlangQAtom.class);
  }

  @Override
  @Nonnull
  public ErlangRuleBody getRuleBody() {
    return findNotNullChildByClass(ErlangRuleBody.class);
  }

}
