// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangTypeGuard extends ErlangCompositeElement {

  @Nullable
  ErlangQAtom getQAtom();

  @Nonnull
  List<ErlangTopType> getTopTypeList();

  @Nullable
  PsiElement getParLeft();

  @Nullable
  PsiElement getParRight();

}
