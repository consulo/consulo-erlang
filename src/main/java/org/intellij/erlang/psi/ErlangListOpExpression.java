// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangListOpExpression extends ErlangFakeBinaryExpression {

  @Nonnull
  List<ErlangExpression> getExpressionList();

  @Nullable
  PsiElement getOpMinusMinus();

  @Nullable
  PsiElement getOpPlusPlus();

}
