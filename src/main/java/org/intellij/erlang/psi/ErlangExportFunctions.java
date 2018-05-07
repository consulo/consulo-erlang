// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangExportFunctions extends ErlangCompositeElement {

  @Nonnull
  List<ErlangExportFunction> getExportFunctionList();

  @Nonnull
  PsiElement getBracketLeft();

  @Nullable
  PsiElement getBracketRight();

}
