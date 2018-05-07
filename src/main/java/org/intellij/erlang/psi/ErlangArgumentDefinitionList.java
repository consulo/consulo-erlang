// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface ErlangArgumentDefinitionList extends ErlangCompositeElement {

  @Nonnull
  List<ErlangArgumentDefinition> getArgumentDefinitionList();

  @Nonnull
  PsiElement getParLeft();

  @Nullable
  PsiElement getParRight();

}
