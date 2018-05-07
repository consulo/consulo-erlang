// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;

import javax.annotation.*;

import org.intellij.erlang.psi.*;

public class ErlangSpecificationImpl extends ErlangCompositeElementImpl implements ErlangSpecification {

  public ErlangSpecificationImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitSpecification(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ErlangFunTypeSigs getFunTypeSigs() {
    return findChildByClass(ErlangFunTypeSigs.class);
  }

  @Override
  @Nullable
  public ErlangFunTypeSigsBraces getFunTypeSigsBraces() {
    return findChildByClass(ErlangFunTypeSigsBraces.class);
  }

  @Nullable
  public ErlangFunTypeSigs getSignature() {
    return ErlangPsiImplUtil.getSignature(this);
  }

}
