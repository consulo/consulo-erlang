// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangIfExpression extends ErlangExpression {

  @Nonnull
  List<ErlangIfClause> getIfClauseList();

  @Nullable
  PsiElement getEnd();

  @Nonnull
  PsiElement getIf();

}
