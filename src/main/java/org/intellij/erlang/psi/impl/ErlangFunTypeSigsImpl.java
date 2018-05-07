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

public class ErlangFunTypeSigsImpl extends ErlangCompositeElementImpl implements ErlangFunTypeSigs {

  public ErlangFunTypeSigsImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitFunTypeSigs(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ErlangModuleRef getModuleRef() {
    return findChildByClass(ErlangModuleRef.class);
  }

  @Override
  @Nonnull
  public ErlangSpecFun getSpecFun() {
    return findNotNullChildByClass(ErlangSpecFun.class);
  }

  @Override
  @Nonnull
  public List<ErlangTypeSig> getTypeSigList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ErlangTypeSig.class);
  }

  @Override
  @Nullable
  public PsiElement getColon() {
    return findChildByType(ERL_COLON);
  }

  @Override
  @Nullable
  public PsiElement getColonColon() {
    return findChildByType(ERL_COLON_COLON);
  }

}
