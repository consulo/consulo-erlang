// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangLcExpression extends ErlangExpression {

  @Nullable
  ErlangArgumentDefinition getArgumentDefinition();

  @Nonnull
  ErlangExpression getExpression();

  @Nullable
  PsiElement getOpLtEq();

  @Nullable
  PsiElement getOpLtMinus();

}
