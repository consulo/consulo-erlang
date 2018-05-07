// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.Nullable;

import com.intellij.psi.PsiElement;

public interface ErlangImportDirective extends ErlangCompositeElement {

  @Nullable
  ErlangImportFunctions getImportFunctions();

  @Nullable
  ErlangModuleRef getModuleRef();

  @Nullable
  PsiElement getComma();

  @Nullable
  PsiElement getParLeft();

  @Nullable
  PsiElement getParRight();

}
