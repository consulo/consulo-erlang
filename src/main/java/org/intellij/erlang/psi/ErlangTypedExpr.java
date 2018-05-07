// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangTypedExpr extends ErlangNamedElement {

  @Nullable
  ErlangExpression getExpression();

  @Nonnull
  ErlangQAtom getQAtom();

  @Nullable
  ErlangTopType getTopType();

  @Nullable
  PsiElement getColonColon();

  @Nullable
  PsiElement getOpEq();

  @Nonnull
  String getName();

  @Nonnull
  PsiElement setName(String newName);

  @Nonnull
  PsiElement getNameIdentifier();

  int getTextOffset();

}
