// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangGlobalFunctionCallExpression extends ErlangExpression {

  @Nullable
  ErlangFunctionCallExpression getFunctionCallExpression();

  @Nullable
  ErlangModuleRef getModuleRef();

  @Nullable
  ErlangQAtom getQAtom();

  @Nonnull
  PsiElement getColon();

  @Nullable
  PsiElement getDot();

}
