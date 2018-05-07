// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;

import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;
import org.intellij.erlang.stubs.ErlangFunctionStub;
import com.intellij.navigation.ItemPresentation;

import javax.annotation.Nonnull;
import javax.swing.Icon;

public interface ErlangFunction extends ErlangNamedElement, StubBasedPsiElement<ErlangFunctionStub> {

  @Nonnull
  List<ErlangFunctionClause> getFunctionClauseList();

  @Nonnull
  ErlangQAtom getAtomName();

  @Nonnull
  String getName();

  @Nonnull
  PsiElement setName(String newName);

  int getArity();

  @Nonnull
  PsiElement getNameIdentifier();

  @Nonnull
  ItemPresentation getPresentation();

  @Nonnull
  Icon getIcon(int flags);

  boolean isExported();

}
