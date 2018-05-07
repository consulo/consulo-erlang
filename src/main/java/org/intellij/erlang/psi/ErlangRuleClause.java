// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.*;

public interface ErlangRuleClause extends ErlangCompositeElement {

  @Nonnull
  ErlangArgumentList getArgumentList();

  @Nullable
  ErlangClauseGuard getClauseGuard();

  @Nonnull
  ErlangQAtom getQAtom();

  @Nonnull
  ErlangRuleBody getRuleBody();

}
