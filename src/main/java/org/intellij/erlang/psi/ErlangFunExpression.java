// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangFunExpression extends ErlangExpression {

  @Nullable
  ErlangFunClauses getFunClauses();

  @Nullable
  ErlangFunctionWithArity getFunctionWithArity();

  @Nullable
  ErlangFunctionWithArityVariables getFunctionWithArityVariables();

  @Nullable
  ErlangModuleRef getModuleRef();

  @Nullable
  ErlangQVar getQVar();

  @Nullable
  PsiElement getColon();

  @Nullable
  PsiElement getEnd();

  @Nonnull
  PsiElement getFun();

}
