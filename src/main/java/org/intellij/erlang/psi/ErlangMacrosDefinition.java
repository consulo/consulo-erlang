// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.*;

import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;
import org.intellij.erlang.stubs.ErlangMacrosDefinitionStub;

public interface ErlangMacrosDefinition extends ErlangNamedElement, StubBasedPsiElement<ErlangMacrosDefinitionStub> {

  @Nullable
  ErlangArgumentDefinitionList getArgumentDefinitionList();

  @Nullable
  ErlangMacrosBody getMacrosBody();

  @Nullable
  ErlangMacrosName getMacrosName();

  @Nullable
  PsiElement getComma();

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

}
