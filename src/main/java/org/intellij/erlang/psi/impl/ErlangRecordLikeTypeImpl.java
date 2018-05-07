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

public class ErlangRecordLikeTypeImpl extends ErlangTypeImpl implements ErlangRecordLikeType {

  public ErlangRecordLikeTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitRecordLikeType(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public List<ErlangTopType> getTopTypeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ErlangTopType.class);
  }

  @Override
  @Nonnull
  public PsiElement getCurlyLeft() {
    return findNotNullChildByType(ERL_CURLY_LEFT);
  }

  @Override
  @Nonnull
  public PsiElement getCurlyRight() {
    return findNotNullChildByType(ERL_CURLY_RIGHT);
  }

}
