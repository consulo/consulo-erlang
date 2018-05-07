// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangArgumentList extends ErlangCompositeElement {

  @Nonnull
  List<ErlangClauseGuard> getClauseGuardList();

  @Nonnull
  List<ErlangExpression> getExpressionList();

  @Nonnull
  PsiElement getParLeft();

  @Nullable
  PsiElement getParRight();

}
