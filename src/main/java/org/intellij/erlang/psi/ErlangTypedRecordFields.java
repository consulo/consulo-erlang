// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangTypedRecordFields extends ErlangCompositeElement {

  @Nonnull
  List<ErlangGenericFunctionCallExpression> getGenericFunctionCallExpressionList();

  @Nonnull
  List<ErlangTypedExpr> getTypedExprList();

  @Nonnull
  PsiElement getCurlyLeft();

  @Nullable
  PsiElement getCurlyRight();

}
