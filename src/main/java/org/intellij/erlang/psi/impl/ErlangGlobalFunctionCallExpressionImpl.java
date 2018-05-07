// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;

import static org.intellij.erlang.ErlangTypes.*;

import javax.annotation.*;

import org.intellij.erlang.psi.*;

public class ErlangGlobalFunctionCallExpressionImpl extends ErlangExpressionImpl implements ErlangGlobalFunctionCallExpression {

  public ErlangGlobalFunctionCallExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitGlobalFunctionCallExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ErlangFunctionCallExpression getFunctionCallExpression() {
    return findChildByClass(ErlangFunctionCallExpression.class);
  }

  @Override
  @Nullable
  public ErlangModuleRef getModuleRef() {
    return findChildByClass(ErlangModuleRef.class);
  }

  @Override
  @Nullable
  public ErlangQAtom getQAtom() {
    return findChildByClass(ErlangQAtom.class);
  }

  @Override
  @Nonnull
  public PsiElement getColon() {
    return findNotNullChildByType(ERL_COLON);
  }

  @Override
  @Nullable
  public PsiElement getDot() {
    return findChildByType(ERL_DOT);
  }

}
