// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.Nullable;

import com.intellij.psi.PsiElement;

public interface ErlangPrefixExpression extends ErlangExpression {

  @Nullable
  ErlangExpression getExpression();

  @Nullable
  PsiElement getOpMinus();

  @Nullable
  PsiElement getOpPlus();

  @Nullable
  PsiElement getBnot();

  @Nullable
  PsiElement getNot();

}
