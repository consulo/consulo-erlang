package org.intellij.erlang.psi;

import javax.annotation.Nonnull;
import java.util.List;

public interface ErlangClauseOwner {
  @Nonnull
  List<ErlangCrClause> getCrClauseList();
}
