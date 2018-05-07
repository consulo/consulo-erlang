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

public class ErlangExportTypesImpl extends ErlangCompositeElementImpl implements ErlangExportTypes {

  public ErlangExportTypesImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitExportTypes(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public List<ErlangExportType> getExportTypeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ErlangExportType.class);
  }

  @Override
  @Nonnull
  public PsiElement getBracketLeft() {
    return findNotNullChildByType(ERL_BRACKET_LEFT);
  }

  @Override
  @Nullable
  public PsiElement getBracketRight() {
    return findChildByType(ERL_BRACKET_RIGHT);
  }

}
