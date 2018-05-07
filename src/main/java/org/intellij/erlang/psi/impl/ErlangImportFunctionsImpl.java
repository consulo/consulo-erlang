// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import java.util.List;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.erlang.ErlangTypes.*;

import javax.annotation.Nonnull;

import org.intellij.erlang.psi.*;

public class ErlangImportFunctionsImpl extends ErlangCompositeElementImpl implements ErlangImportFunctions {

  public ErlangImportFunctionsImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitImportFunctions(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public List<ErlangImportFunction> getImportFunctionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ErlangImportFunction.class);
  }

  @Override
  @Nonnull
  public PsiElement getBracketLeft() {
    return findNotNullChildByType(ERL_BRACKET_LEFT);
  }

  @Override
  @Nonnull
  public PsiElement getBracketRight() {
    return findNotNullChildByType(ERL_BRACKET_RIGHT);
  }

}
