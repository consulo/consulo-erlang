// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangFunTypeSigs extends ErlangCompositeElement {

  @Nullable
  ErlangModuleRef getModuleRef();

  @Nonnull
  ErlangSpecFun getSpecFun();

  @Nonnull
  List<ErlangTypeSig> getTypeSigList();

  @Nullable
  PsiElement getColon();

  @Nullable
  PsiElement getColonColon();

}
