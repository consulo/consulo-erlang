// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;

import javax.annotation.Nonnull;

import org.intellij.erlang.psi.*;

public class ErlangMacrosArgImpl extends ErlangCompositeElementImpl implements ErlangMacrosArg {

  public ErlangMacrosArgImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitMacrosArg(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public ErlangMacrosName getMacrosName() {
    return findNotNullChildByClass(ErlangMacrosName.class);
  }

}
