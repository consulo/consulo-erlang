// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;

import static org.intellij.erlang.ErlangTypes.*;

import javax.annotation.*;

import org.intellij.erlang.psi.*;

public class ErlangFunExpressionImpl extends ErlangExpressionImpl implements ErlangFunExpression {

  public ErlangFunExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitFunExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ErlangFunClauses getFunClauses() {
    return findChildByClass(ErlangFunClauses.class);
  }

  @Override
  @Nullable
  public ErlangFunctionWithArity getFunctionWithArity() {
    return findChildByClass(ErlangFunctionWithArity.class);
  }

  @Override
  @Nullable
  public ErlangFunctionWithArityVariables getFunctionWithArityVariables() {
    return findChildByClass(ErlangFunctionWithArityVariables.class);
  }

  @Override
  @Nullable
  public ErlangModuleRef getModuleRef() {
    return findChildByClass(ErlangModuleRef.class);
  }

  @Override
  @Nullable
  public ErlangQVar getQVar() {
    return findChildByClass(ErlangQVar.class);
  }

  @Override
  @Nullable
  public PsiElement getColon() {
    return findChildByType(ERL_COLON);
  }

  @Override
  @Nullable
  public PsiElement getEnd() {
    return findChildByType(ERL_END);
  }

  @Override
  @Nonnull
  public PsiElement getFun() {
    return findNotNullChildByType(ERL_FUN);
  }

}
