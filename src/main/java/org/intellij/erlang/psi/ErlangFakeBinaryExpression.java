// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;

import javax.annotation.*;

public interface ErlangFakeBinaryExpression extends ErlangExpression {

  @Nonnull
  List<ErlangExpression> getExpressionList();

  @Nonnull
  ErlangExpression getLeft();

  @Nullable
  ErlangExpression getRight();

}
