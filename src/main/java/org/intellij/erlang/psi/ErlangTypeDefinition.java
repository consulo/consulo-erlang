// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.*;

import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;
import org.intellij.erlang.stubs.ErlangTypeDefinitionStub;

public interface ErlangTypeDefinition extends ErlangNamedElement, StubBasedPsiElement<ErlangTypeDefinitionStub> {

  @Nullable
  ErlangArgumentDefinitionList getArgumentDefinitionList();

  @Nullable
  ErlangQAtom getQAtom();

  @Nullable
  ErlangTopType getTopType();

  @Nullable
  PsiElement getColonColon();

  @Nonnull
  PsiElement getOpMinus();

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

  int getArity();

}
