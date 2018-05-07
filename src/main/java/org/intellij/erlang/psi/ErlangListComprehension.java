// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.*;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;

public interface ErlangListComprehension extends ErlangExpression {

  @Nonnull
  ErlangExpression getExpression();

  @Nullable
  ErlangLcExprs getLcExprs();

  @Nonnull
  PsiElement getBracketLeft();

  @Nullable
  PsiElement getBracketRight();

  @Nonnull
  PsiElement getOrOr();

  boolean processDeclarations(PsiScopeProcessor processor, ResolveState state, PsiElement lastParent, PsiElement place);

}
