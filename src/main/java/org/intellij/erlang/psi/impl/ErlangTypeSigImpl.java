// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;

import javax.annotation.*;

import org.intellij.erlang.psi.*;

public class ErlangTypeSigImpl extends ErlangCompositeElementImpl implements ErlangTypeSig {

  public ErlangTypeSigImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitTypeSig(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public ErlangFunType getFunType() {
    return findNotNullChildByClass(ErlangFunType.class);
  }

  @Override
  @Nullable
  public ErlangTypeSigGuard getTypeSigGuard() {
    return findChildByClass(ErlangTypeSigGuard.class);
  }

}
