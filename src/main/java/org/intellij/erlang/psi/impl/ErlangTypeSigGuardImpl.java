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

public class ErlangTypeSigGuardImpl extends ErlangCompositeElementImpl implements ErlangTypeSigGuard {

  public ErlangTypeSigGuardImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitTypeSigGuard(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public List<ErlangTypeGuard> getTypeGuardList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ErlangTypeGuard.class);
  }

  @Override
  @Nonnull
  public PsiElement getWhen() {
    return findNotNullChildByType(ERL_WHEN);
  }

}
