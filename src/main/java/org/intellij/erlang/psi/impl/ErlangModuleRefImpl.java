// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;

import javax.annotation.*;

import org.intellij.erlang.psi.*;
import com.intellij.psi.PsiReference;

public class ErlangModuleRefImpl extends ErlangCompositeElementImpl implements ErlangModuleRef {

  public ErlangModuleRefImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitModuleRef(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public ErlangQAtom getQAtom() {
    return findNotNullChildByClass(ErlangQAtom.class);
  }

  @Nullable
  public PsiReference getReference() {
    return ErlangPsiImplUtil.getReference(this);
  }

}
