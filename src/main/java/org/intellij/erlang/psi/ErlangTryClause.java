// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangTryClause extends ErlangCompositeElement {

  @Nonnull
  List<ErlangArgumentDefinition> getArgumentDefinitionList();

  @Nullable
  ErlangClauseBody getClauseBody();

  @Nullable
  ErlangClauseGuard getClauseGuard();

  @Nullable
  PsiElement getColon();

}
