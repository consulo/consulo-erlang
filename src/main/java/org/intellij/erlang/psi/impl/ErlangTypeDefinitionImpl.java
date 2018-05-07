// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;

import static org.intellij.erlang.ErlangTypes.*;

import javax.annotation.*;

import org.intellij.erlang.stubs.ErlangTypeDefinitionStub;
import org.intellij.erlang.psi.*;
import com.intellij.psi.stubs.IStubElementType;

public class ErlangTypeDefinitionImpl extends ErlangStubbedPsiElementBase<ErlangTypeDefinitionStub> implements ErlangTypeDefinition {

  public ErlangTypeDefinitionImpl(ASTNode node) {
    super(node);
  }

  public ErlangTypeDefinitionImpl(ErlangTypeDefinitionStub stub, IStubElementType nodeType) {
    super(stub, nodeType);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitTypeDefinition(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ErlangArgumentDefinitionList getArgumentDefinitionList() {
    return findChildByClass(ErlangArgumentDefinitionList.class);
  }

  @Override
  @Nullable
  public ErlangQAtom getQAtom() {
    return findChildByClass(ErlangQAtom.class);
  }

  @Override
  @Nullable
  public ErlangTopType getTopType() {
    return findChildByClass(ErlangTopType.class);
  }

  @Override
  @Nullable
  public PsiElement getColonColon() {
    return findChildByType(ERL_COLON_COLON);
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

  @Nonnull
  public String getName() {
    return ErlangPsiImplUtil.getName(this);
  }

  @Nonnull
  public PsiElement setName(String newName) {
    return ErlangPsiImplUtil.setName(this, newName);
  }

  @Nonnull
  public PsiElement getNameIdentifier() {
    return ErlangPsiImplUtil.getNameIdentifier(this);
  }

  public int getTextOffset() {
    return ErlangPsiImplUtil.getTextOffset(this);
  }

  public int getArity() {
    return ErlangPsiImplUtil.getArity(this);
  }

}
