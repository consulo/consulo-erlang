// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;

import javax.annotation.Nonnull;

import com.intellij.psi.PsiElement;

public interface ErlangColonQualifiedExpression extends ErlangExpression {

  @Nonnull
  List<ErlangExpression> getExpressionList();

  @Nonnull
  PsiElement getColon();

}
