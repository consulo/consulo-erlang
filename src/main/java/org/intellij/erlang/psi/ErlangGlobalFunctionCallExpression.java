// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ErlangGlobalFunctionCallExpression extends ErlangExpression {

  @Nullable
  ErlangFunctionCallExpression getFunctionCallExpression();

  @Nullable
  ErlangModuleRef getModuleRef();

  @Nullable
  ErlangQAtom getQAtom();

  @NotNull
  PsiElement getColon();

  @Nullable
  PsiElement getDot();

}
