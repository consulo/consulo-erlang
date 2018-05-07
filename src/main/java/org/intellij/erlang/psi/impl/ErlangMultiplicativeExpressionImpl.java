// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import java.util.List;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.erlang.ErlangTypes.*;

import javax.annotation.*;

import org.intellij.erlang.psi.*;

public class ErlangMultiplicativeExpressionImpl extends ErlangFakeBinaryExpressionImpl implements ErlangMultiplicativeExpression {

  public ErlangMultiplicativeExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitMultiplicativeExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public List<ErlangExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ErlangExpression.class);
  }

  @Override
  @Nullable
  public PsiElement getOpArDiv() {
    return findChildByType(ERL_OP_AR_DIV);
  }

  @Override
  @Nullable
  public PsiElement getOpArMul() {
    return findChildByType(ERL_OP_AR_MUL);
  }

  @Override
  @Nullable
  public PsiElement getAnd() {
    return findChildByType(ERL_AND);
  }

  @Override
  @Nullable
  public PsiElement getBand() {
    return findChildByType(ERL_BAND);
  }

  @Override
  @Nullable
  public PsiElement getDiv() {
    return findChildByType(ERL_DIV);
  }

  @Override
  @Nullable
  public PsiElement getRem() {
    return findChildByType(ERL_REM);
  }

}
