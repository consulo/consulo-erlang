// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;

import javax.annotation.*;

import org.intellij.erlang.psi.*;

public class ErlangFunTypeImpl extends ErlangTypeImpl implements ErlangFunType {

  public ErlangFunTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitFunType(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public ErlangFunTypeArguments getFunTypeArguments() {
    return findNotNullChildByClass(ErlangFunTypeArguments.class);
  }

  @Override
  @Nullable
  public ErlangTopTypeClause getTopTypeClause() {
    return findChildByClass(ErlangTopTypeClause.class);
  }

}
