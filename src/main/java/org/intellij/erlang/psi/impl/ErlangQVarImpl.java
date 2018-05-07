// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;

import static org.intellij.erlang.ErlangTypes.*;

import javax.annotation.*;

import org.intellij.erlang.psi.*;
import com.intellij.psi.PsiReference;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.search.SearchScope;

public class ErlangQVarImpl extends ErlangNamedElementImpl implements ErlangQVar {

  public ErlangQVarImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitQVar(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getUniPattern() {
    return findChildByType(ERL_UNI_PATTERN);
  }

  @Override
  @Nullable
  public PsiElement getVar() {
    return findChildByType(ERL_VAR);
  }

  @Nullable
  public PsiReference getReference() {
    return ErlangPsiImplUtil.getReference(this);
  }

  public boolean processDeclarations(PsiScopeProcessor processor, ResolveState state, PsiElement lastParent, PsiElement place) {
    return ErlangPsiImplUtil.processDeclarations(this, processor, state, lastParent, place);
  }

  @Nonnull
  public String getName() {
    return ErlangPsiImplUtil.getName(this);
  }

  @Nonnull
  public PsiElement setName(String newName) {
    return ErlangPsiImplUtil.setName(this, newName);
  }

  @Nonnull
  public PsiElement getNameIdentifier() {
    return ErlangPsiImplUtil.getNameIdentifier(this);
  }

  @Nonnull
  public SearchScope getUseScope() {
    return ErlangPsiImplUtil.getUseScope(this);
  }

}
