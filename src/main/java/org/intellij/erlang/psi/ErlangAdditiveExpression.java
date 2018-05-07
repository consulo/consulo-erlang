// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangAdditiveExpression extends ErlangFakeBinaryExpression {

  @Nonnull
  List<ErlangExpression> getExpressionList();

  @Nullable
  PsiElement getOpMinus();

  @Nullable
  PsiElement getOpPlus();

  @Nullable
  PsiElement getBor();

  @Nullable
  PsiElement getBsl();

  @Nullable
  PsiElement getBsr();

  @Nullable
  PsiElement getBxor();

  @Nullable
  PsiElement getOr();

  @Nullable
  PsiElement getXor();

}
