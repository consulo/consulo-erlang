// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;

import javax.annotation.Nonnull;

import com.intellij.psi.PsiElement;

public interface ErlangQualifiedExpression extends ErlangExpression {

  @Nonnull
  List<ErlangQAtom> getQAtomList();

  @Nonnull
  PsiElement getDot();

}
