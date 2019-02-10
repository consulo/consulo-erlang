// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi.impl;

import java.util.List;

import javax.annotation.Nonnull;

import org.intellij.erlang.psi.ErlangFunction;
import org.intellij.erlang.psi.ErlangFunctionClause;
import org.intellij.erlang.psi.ErlangQAtom;
import org.intellij.erlang.psi.ErlangVisitor;
import org.intellij.erlang.stubs.ErlangFunctionStub;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.util.PsiTreeUtil;
import consulo.ui.image.Image;

public class ErlangFunctionImpl extends ErlangStubbedPsiElementBase<ErlangFunctionStub> implements ErlangFunction {

  public ErlangFunctionImpl(ASTNode node) {
    super(node);
  }

  public ErlangFunctionImpl(ErlangFunctionStub stub, IStubElementType nodeType) {
    super(stub, nodeType);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof ErlangVisitor) ((ErlangVisitor)visitor).visitFunction(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public List<ErlangFunctionClause> getFunctionClauseList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ErlangFunctionClause.class);
  }

  @Override
  @Nonnull
  public ErlangQAtom getAtomName() {
    List<ErlangFunctionClause> p1 = getFunctionClauseList();
    ErlangFunctionClause p2 = p1.get(0);
    return p2.getQAtom();
  }

  @Nonnull
  public String getName() {
    return ErlangPsiImplUtil.getName(this);
  }

  @Nonnull
  public PsiElement setName(String newName) {
    return ErlangPsiImplUtil.setName(this, newName);
  }

  public int getArity() {
    return ErlangPsiImplUtil.getArity(this);
  }

  @Nonnull
  public PsiElement getNameIdentifier() {
    return ErlangPsiImplUtil.getNameIdentifier(this);
  }

  @Nonnull
  public ItemPresentation getPresentation() {
    return ErlangPsiImplUtil.getPresentation(this);
  }

  @Nonnull
  public Image getIcon(int flags) {
    return ErlangPsiImplUtil.getIcon(this, flags);
  }

  public boolean isExported() {
    return ErlangPsiImplUtil.isExported(this);
  }

}
