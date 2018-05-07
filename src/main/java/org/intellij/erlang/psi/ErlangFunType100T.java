// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangFunType100T extends ErlangType {

  @Nonnull
  List<ErlangTopType> getTopTypeList();

  @Nullable
  ErlangTopTypeClause getTopTypeClause();

  @Nullable
  PsiElement getDotDotDot();

  @Nonnull
  PsiElement getParLeft();

  @Nullable
  PsiElement getParRight();

}
