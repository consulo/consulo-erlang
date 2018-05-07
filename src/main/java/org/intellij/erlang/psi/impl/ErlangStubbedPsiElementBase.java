package org.intellij.erlang.psi.impl;

import javax.annotation.Nonnull;

import com.intellij.extapi.psi.StubBasedPsiElementBase;
import com.intellij.lang.ASTNode;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubElement;
import org.intellij.erlang.psi.ErlangCompositeElement;

public class ErlangStubbedPsiElementBase<T extends StubElement<?>> extends StubBasedPsiElementBase<T> implements ErlangCompositeElement {
  public ErlangStubbedPsiElementBase(@Nonnull T stub, @Nonnull IStubElementType nodeType) {
    super(stub, nodeType);
  }

  public ErlangStubbedPsiElementBase(@Nonnull ASTNode node) {
    super(node);
  }

  @Override
  public String toString() {
    return getElementType().toString();
  }
}
