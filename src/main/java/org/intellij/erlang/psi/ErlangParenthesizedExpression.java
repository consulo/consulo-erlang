// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangParenthesizedExpression extends ErlangExpression {

  @Nullable
  ErlangExpression getExpression();

  @Nonnull
  PsiElement getParLeft();

  @Nullable
  PsiElement getParRight();

}
