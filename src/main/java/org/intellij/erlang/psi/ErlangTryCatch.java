// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.Nullable;

import com.intellij.psi.PsiElement;

public interface ErlangTryCatch extends ErlangCompositeElement {

  @Nullable
  ErlangTryClauses getTryClauses();

  @Nullable
  ErlangTryExpressionsClause getTryExpressionsClause();

  @Nullable
  PsiElement getAfter();

  @Nullable
  PsiElement getCatch();

}
