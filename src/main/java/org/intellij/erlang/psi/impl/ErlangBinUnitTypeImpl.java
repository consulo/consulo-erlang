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

public class ErlangBinUnitTypeImpl extends ErlangTypeImpl implements ErlangBinUnitType {

  public ErlangBinUnitTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitBinUnitType(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public List<ErlangQVar> getQVarList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ErlangQVar.class);
  }

  @Override
  @Nonnull
  public PsiElement getColon() {
    return findNotNullChildByType(ERL_COLON);
  }

  @Override
  @Nonnull
  public PsiElement getOpArMul() {
    return findNotNullChildByType(ERL_OP_AR_MUL);
  }

  @Override
  @Nonnull
  public PsiElement getInteger() {
    return findNotNullChildByType(ERL_INTEGER);
  }

}
