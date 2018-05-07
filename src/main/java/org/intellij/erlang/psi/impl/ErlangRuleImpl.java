// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import java.util.List;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;

import javax.annotation.Nonnull;

import org.intellij.erlang.psi.*;

public class ErlangRuleImpl extends ErlangCompositeElementImpl implements ErlangRule {

  public ErlangRuleImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitRule(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public List<ErlangRuleClause> getRuleClauseList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ErlangRuleClause.class);
  }

}
