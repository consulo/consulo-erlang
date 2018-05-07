// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangGenericFunctionCallExpression extends ErlangExpression {

  @Nonnull
  ErlangArgumentList getArgumentList();

  @Nullable
  ErlangMacros getMacros();

  @Nonnull
  List<ErlangQAtom> getQAtomList();

  @Nonnull
  List<ErlangQVar> getQVarList();

  @Nullable
  PsiElement getColon();

}
