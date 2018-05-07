// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.*;

import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;
import org.intellij.erlang.stubs.ErlangModuleStub;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;

public interface ErlangModule extends ErlangNamedElement, StubBasedPsiElement<ErlangModuleStub> {

  @Nullable
  ErlangArgumentDefinition getArgumentDefinition();

  @Nullable
  ErlangModelFieldList getModelFieldList();

  @Nullable
  ErlangQAtom getQAtom();

  @Nullable
  PsiElement getComma();

  @Nullable
  PsiElement getParLeft();

  @Nullable
  PsiElement getParRight();

  @Nonnull
  String getName();

  @Nonnull
  PsiElement setName(String newName);

  @Nonnull
  PsiElement getNameIdentifier();

  int getTextOffset();

  boolean processDeclarations(PsiScopeProcessor processor, ResolveState state, PsiElement lastParent, PsiElement place);

}
