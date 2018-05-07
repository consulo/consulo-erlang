// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import java.util.List;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.erlang.ErlangTypes.*;

import javax.annotation.*;

import org.intellij.erlang.psi.*;

public class ErlangFunctionWithArityVariablesImpl extends ErlangCompositeElementImpl implements ErlangFunctionWithArityVariables {

  public ErlangFunctionWithArityVariablesImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitFunctionWithArityVariables(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public List<ErlangQVar> getQVarList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ErlangQVar.class);
  }

  @Override
  @Nullable
  public PsiElement getOpArDiv() {
    return findChildByType(ERL_OP_AR_DIV);
  }

  @Override
  @Nullable
  public PsiElement getInteger() {
    return findChildByType(ERL_INTEGER);
  }

}
