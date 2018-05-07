// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangBinaryExpression extends ErlangExpression {

  @Nonnull
  List<ErlangBinElement> getBinElementList();

  @Nullable
  PsiElement getBinEnd();

  @Nonnull
  PsiElement getBinStart();

}
