// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.*;

public interface ErlangFunClause extends ErlangCompositeElement {

  @Nullable
  ErlangArgumentDefinition getArgumentDefinition();

  @Nonnull
  ErlangArgumentDefinitionList getArgumentDefinitionList();

  @Nullable
  ErlangClauseBody getClauseBody();

  @Nullable
  ErlangClauseGuard getClauseGuard();

}
