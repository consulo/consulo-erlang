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

public class ErlangQualifiedExpressionImpl extends ErlangExpressionImpl implements ErlangQualifiedExpression {

  public ErlangQualifiedExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitQualifiedExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public List<ErlangQAtom> getQAtomList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ErlangQAtom.class);
  }

  @Override
  @Nonnull
  public PsiElement getDot() {
    return findNotNullChildByType(ERL_DOT);
  }

}
