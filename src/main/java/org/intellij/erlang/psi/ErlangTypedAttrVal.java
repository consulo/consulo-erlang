// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangTypedAttrVal extends ErlangCompositeElement {

  @Nonnull
  ErlangExpression getExpression();

  @Nullable
  ErlangTopType getTopType();

  @Nullable
  ErlangTypedRecordFields getTypedRecordFields();

  @Nullable
  PsiElement getColonColon();

  @Nullable
  PsiElement getComma();

}
