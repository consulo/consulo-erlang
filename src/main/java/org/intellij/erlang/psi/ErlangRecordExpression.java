// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.*;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public interface ErlangRecordExpression extends ErlangExpression {

  @Nonnull
  ErlangExpression getExpression();

  @Nullable
  ErlangMacros getMacros();

  @Nullable
  ErlangRecordField getRecordField();

  @Nullable
  ErlangRecordRef getRecordRef();

  @Nullable
  ErlangRecordTuple getRecordTuple();

  @Nullable
  PsiElement getRadix();

  @Nullable
  PsiReference getReferenceInternal();

}
