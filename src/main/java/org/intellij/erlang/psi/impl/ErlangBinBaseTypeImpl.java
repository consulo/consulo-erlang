// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;

import static org.intellij.erlang.ErlangTypes.*;

import javax.annotation.Nonnull;

import org.intellij.erlang.psi.*;

public class ErlangBinBaseTypeImpl extends ErlangTypeImpl implements ErlangBinBaseType {

  public ErlangBinBaseTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitBinBaseType(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public ErlangQVar getQVar() {
    return findNotNullChildByClass(ErlangQVar.class);
  }

  @Override
  @Nonnull
  public PsiElement getColon() {
    return findNotNullChildByType(ERL_COLON);
  }

  @Override
  @Nonnull
  public PsiElement getInteger() {
    return findNotNullChildByType(ERL_INTEGER);
  }

}
