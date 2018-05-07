// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;

import static org.intellij.erlang.ErlangTypes.*;

import javax.annotation.*;

import org.intellij.erlang.psi.*;

public class ErlangAtomAttributeImpl extends ErlangCompositeElementImpl implements ErlangAtomAttribute {

  public ErlangAtomAttributeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitAtomAttribute(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ErlangAttrVal getAttrVal() {
    return findChildByClass(ErlangAttrVal.class);
  }

  @Override
  @Nonnull
  public ErlangQAtom getQAtom() {
    return findNotNullChildByClass(ErlangQAtom.class);
  }

  @Override
  @Nullable
  public ErlangTypedAttrVal getTypedAttrVal() {
    return findChildByClass(ErlangTypedAttrVal.class);
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

}
