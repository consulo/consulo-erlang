// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.*;

import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;
import org.intellij.erlang.stubs.ErlangBehaviourStub;

public interface ErlangBehaviour extends ErlangCompositeElement, StubBasedPsiElement<ErlangBehaviourStub> {

  @Nullable
  ErlangModuleRef getModuleRef();

  @Nullable
  PsiElement getParLeft();

  @Nullable
  PsiElement getParRight();

  @Nonnull
  String getName();

}
