// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangAtomAttribute extends ErlangCompositeElement {

  @Nullable
  ErlangAttrVal getAttrVal();

  @Nonnull
  ErlangQAtom getQAtom();

  @Nullable
  ErlangTypedAttrVal getTypedAttrVal();

  @Nullable
  PsiElement getParLeft();

  @Nullable
  PsiElement getParRight();

}
