// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.*;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.search.SearchScope;

public interface ErlangQVar extends ErlangNamedElement {

  @Nullable
  PsiElement getUniPattern();

  @Nullable
  PsiElement getVar();

  @Nullable
  PsiReference getReference();

  boolean processDeclarations(PsiScopeProcessor processor, ResolveState state, PsiElement lastParent, PsiElement place);

  @Nonnull
  String getName();

  @Nonnull
  PsiElement setName(String newName);

  @Nonnull
  PsiElement getNameIdentifier();

  @Nonnull
  SearchScope getUseScope();

}
