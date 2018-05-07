// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;

import javax.annotation.*;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public interface ErlangRecordField extends ErlangCompositeElement {

  @Nullable
  ErlangExpression getExpression();

  @Nonnull
  List<ErlangQAtom> getQAtomList();

  @Nullable
  PsiElement getDot();

  @Nullable
  PsiElement getOpEq();

  @Nullable
  PsiElement getUniPattern();

  @Nullable
  PsiReference getReference();

  @Nullable
  ErlangQAtom getFieldNameAtom();

}
