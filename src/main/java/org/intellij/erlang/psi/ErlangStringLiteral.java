// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import javax.annotation.Nonnull;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import org.intellij.erlang.ErlangStringLiteralEscaper;

public interface ErlangStringLiteral extends ErlangExpression, PsiLanguageInjectionHost {

  @Nonnull
  PsiElement getString();

  boolean isValidHost();

  ErlangStringLiteral updateText(String text);

  @Nonnull
  ErlangStringLiteralEscaper createLiteralTextEscaper();

}
