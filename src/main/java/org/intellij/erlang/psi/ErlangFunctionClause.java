// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.*;

public interface ErlangFunctionClause extends ErlangCompositeElement {

  @Nonnull
  ErlangArgumentDefinitionList getArgumentDefinitionList();

  @Nonnull
  ErlangClauseBody getClauseBody();

  @Nullable
  ErlangClauseGuard getClauseGuard();

  @Nonnull
  ErlangQAtom getQAtom();

}
