// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.*;

import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;
import org.intellij.erlang.stubs.ErlangIncludeStub;

public interface ErlangInclude extends ErlangCompositeElement, StubBasedPsiElement<ErlangIncludeStub> {

  @Nullable
  ErlangIncludeString getIncludeString();

  @Nonnull
  PsiElement getOpMinus();

  @Nullable
  PsiElement getParLeft();

  @Nullable
  PsiElement getParRight();

  @Nullable
  ErlangIncludeString getIncludeStringSafe();

}
