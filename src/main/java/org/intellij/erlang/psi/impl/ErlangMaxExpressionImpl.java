// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;

import static org.intellij.erlang.ErlangTypes.*;

import javax.annotation.*;

import org.intellij.erlang.psi.*;

public class ErlangMaxExpressionImpl extends ErlangExpressionImpl implements ErlangMaxExpression {

  public ErlangMaxExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitMaxExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ErlangQAtom getQAtom() {
    return findChildByClass(ErlangQAtom.class);
  }

  @Override
  @Nullable
  public ErlangQVar getQVar() {
    return findChildByClass(ErlangQVar.class);
  }

  @Override
  @Nullable
  public PsiElement getChar() {
    return findChildByType(ERL_CHAR);
  }

  @Override
  @Nullable
  public PsiElement getFloat() {
    return findChildByType(ERL_FLOAT);
  }

  @Override
  @Nullable
  public PsiElement getInteger() {
    return findChildByType(ERL_INTEGER);
  }

}
