// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.*;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public interface ErlangFunctionCallExpression extends ErlangExpression {

  @Nonnull
  ErlangArgumentList getArgumentList();

  @Nonnull
  ErlangQAtom getQAtom();

  @Nullable
  PsiReference getReference();

  @Nonnull
  PsiElement getNameIdentifier();

  int getTextOffset();

  @Nonnull
  String getName();

}
