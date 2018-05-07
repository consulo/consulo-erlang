// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;

import javax.annotation.*;

import org.intellij.erlang.stubs.ErlangCallbackSpecStub;
import org.intellij.erlang.psi.*;
import com.intellij.psi.stubs.IStubElementType;

public class ErlangCallbackSpecImpl extends ErlangStubbedPsiElementBase<ErlangCallbackSpecStub> implements ErlangCallbackSpec {

  public ErlangCallbackSpecImpl(ASTNode node) {
    super(node);
  }

  public ErlangCallbackSpecImpl(ErlangCallbackSpecStub stub, IStubElementType nodeType) {
    super(stub, nodeType);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitCallbackSpec(this);
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

}
