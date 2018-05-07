// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import java.util.List;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;

import javax.annotation.Nonnull;

import org.intellij.erlang.psi.*;

public class ErlangRecordFieldsImpl extends ErlangCompositeElementImpl implements ErlangRecordFields {

  public ErlangRecordFieldsImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitRecordFields(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public List<ErlangRecordField> getRecordFieldList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ErlangRecordField.class);
  }

}
