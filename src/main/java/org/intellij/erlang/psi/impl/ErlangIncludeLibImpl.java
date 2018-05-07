// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;

import static org.intellij.erlang.ErlangTypes.*;

import javax.annotation.*;

import org.intellij.erlang.stubs.ErlangIncludeLibStub;
import org.intellij.erlang.psi.*;
import com.intellij.psi.stubs.IStubElementType;

public class ErlangIncludeLibImpl extends ErlangStubbedPsiElementBase<ErlangIncludeLibStub> implements ErlangIncludeLib {

  public ErlangIncludeLibImpl(ASTNode node) {
    super(node);
  }

  public ErlangIncludeLibImpl(ErlangIncludeLibStub stub, IStubElementType nodeType) {
    super(stub, nodeType);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitIncludeLib(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ErlangIncludeString getIncludeString() {
    return findChildByClass(ErlangIncludeString.class);
  }

  @Override
  @Nonnull
  public PsiElement getOpMinus() {
    return findNotNullChildByType(ERL_OP_MINUS);
  }

  @Override
  @Nullable
  public PsiElement getParLeft() {
    return findChildByType(ERL_PAR_LEFT);
  }

  @Override
  @Nullable
  public PsiElement getParRight() {
    return findChildByType(ERL_PAR_RIGHT);
  }

  @Nullable
  public ErlangIncludeString getIncludeStringSafe() {
    return ErlangPsiImplUtil.getIncludeStringSafe(this);
  }

}
