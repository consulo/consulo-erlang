// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangReceiveExpression extends ErlangExpression, ErlangClauseOwner {

  @Nullable
  ErlangAfterClause getAfterClause();

  @Nonnull
  List<ErlangCrClause> getCrClauseList();

  @Nullable
  PsiElement getEnd();

  @Nonnull
  PsiElement getReceive();

}
