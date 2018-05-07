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

public class ErlangTypedRecordFieldsImpl extends ErlangCompositeElementImpl implements ErlangTypedRecordFields {

  public ErlangTypedRecordFieldsImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitTypedRecordFields(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public List<ErlangGenericFunctionCallExpression> getGenericFunctionCallExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ErlangGenericFunctionCallExpression.class);
  }

  @Override
  @Nonnull
  public List<ErlangTypedExpr> getTypedExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ErlangTypedExpr.class);
  }

  @Override
  @Nonnull
  public PsiElement getCurlyLeft() {
    return findNotNullChildByType(ERL_CURLY_LEFT);
  }

  @Override
  @Nullable
  public PsiElement getCurlyRight() {
    return findChildByType(ERL_CURLY_RIGHT);
  }

}
