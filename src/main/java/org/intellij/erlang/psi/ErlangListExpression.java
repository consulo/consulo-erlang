// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangListExpression extends ErlangExpression {

  @Nonnull
  List<ErlangExpression> getExpressionList();

  @Nonnull
  PsiElement getBracketLeft();

  @Nullable
  PsiElement getBracketRight();

  @Nullable
  PsiElement getComma();

  @Nullable
  PsiElement getOpOr();

}
