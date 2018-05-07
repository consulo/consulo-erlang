// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.*;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public interface ErlangFieldType extends ErlangType {

  @Nonnull
  ErlangQAtom getQAtom();

  @Nullable
  ErlangTopType getTopType();

  @Nullable
  PsiElement getColonColon();

  @Nullable
  PsiReference getReference();

}
