// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangCaseExpression extends ErlangExpression, ErlangClauseOwner {

  @Nonnull
  List<ErlangCrClause> getCrClauseList();

  @Nullable
  ErlangExpression getExpression();

  @Nonnull
  PsiElement getCase();

  @Nullable
  PsiElement getEnd();

  @Nullable
  PsiElement getOf();

}
