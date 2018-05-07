// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangBinaryType extends ErlangType {

  @Nonnull
  List<ErlangType> getTypeList();

  @Nullable
  PsiElement getBinEnd();

  @Nonnull
  PsiElement getBinStart();

  @Nullable
  PsiElement getComma();

}
