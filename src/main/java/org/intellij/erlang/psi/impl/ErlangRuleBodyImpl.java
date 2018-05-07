// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;

import javax.annotation.*;

import org.intellij.erlang.psi.*;

public class ErlangRuleBodyImpl extends ErlangCompositeElementImpl implements ErlangRuleBody {

  public ErlangRuleBodyImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitRuleBody(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ErlangLcExprs getLcExprs() {
    return findChildByClass(ErlangLcExprs.class);
  }

}
