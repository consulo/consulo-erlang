// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;

import static org.intellij.erlang.ErlangTypes.*;

import javax.annotation.*;

import org.intellij.erlang.psi.*;

public class ErlangIntTypeImpl extends ErlangTypeImpl implements ErlangIntType {

  public ErlangIntTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitIntType(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ErlangArgumentList getArgumentList() {
    return findChildByClass(ErlangArgumentList.class);
  }

  @Override
  @Nullable
  public ErlangMacros getMacros() {
    return findChildByClass(ErlangMacros.class);
  }

  @Override
  @Nullable
  public PsiElement getOpMinus() {
    return findChildByType(ERL_OP_MINUS);
  }

  @Override
  @Nullable
  public PsiElement getInteger() {
    return findChildByType(ERL_INTEGER);
  }

}