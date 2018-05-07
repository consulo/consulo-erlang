/*
 * Copyright 2012-2013 Sergey Ignatov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.intellij.erlang.psi.impl;

import javax.annotation.Nonnull;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import org.intellij.erlang.ErlangLanguage;
import org.intellij.erlang.psi.*;

@SuppressWarnings("ConstantConditions")
public class ErlangElementFactory {
  private ErlangElementFactory() {
  }

  @Nonnull
  public static PsiElement createQAtomFromText(@Nonnull Project project, @Nonnull String text) {
    ErlangFile fileFromText = createFileFromText(project, "-" + text + ".");
    return fileFromText.getAttributes().get(0).getAtomAttribute().getQAtom().getAtom();
  }

  @Nonnull
  public static PsiElement createQVarFromText(@Nonnull Project project, @Nonnull String text) {
    return ((ErlangMaxExpression) createExpressionFromText(project, text)).getQVar();
  }

  @Nonnull
  public static ErlangExpression createExpressionFromText(@Nonnull Project project, @Nonnull String text) {
    ErlangFile fileFromText = createFileFromText(project, "f(" + text + ") -> " + text + ".");
    return fileFromText.getFunctions().get(0).getFunctionClauseList().get(0).getClauseBody().getExpressionList().get(0);
  }

  @Nonnull
  public static ErlangFunction createFunctionFromText(@Nonnull Project project, @Nonnull String text) {
    ErlangFile fileFromText = createFileFromText(project, text);
    return fileFromText.getFunctions().get(0);
  }

  @Nonnull
  public static PsiElement createMacrosFromText(@Nonnull Project project, @Nonnull String text) {
    ErlangFile fileFromText = createFileFromText(project, "-define(" + text + ", 1).");
    return fileFromText.getMacroses().get(0).getMacrosName();
  }

  @Nonnull
  public static PsiElement createStringFromText(@Nonnull Project project, @Nonnull String text) {
    return createIncludeString(project, text).getString();
  }

  @Nonnull
  public static ErlangIncludeString createIncludeString(@Nonnull Project project, @Nonnull String text) {
    ErlangFile fileFromText = createFileFromText(project, "-include(\"" + text + "\").");
    return fileFromText.getIncludes().get(0).getIncludeStringSafe();
  }

  @Nonnull
  public static PsiElement createExportFromText(@Nonnull Project project, @Nonnull String text) {
    ErlangFile fileFromText = createFileFromText(project, "-export([" + text + "]).");
    return fileFromText.getAttributes().get(0);
  }

  @Nonnull
  public static PsiElement createExportTypeFromText(@Nonnull Project project, @Nonnull String text) {
    ErlangFile fileFromText = createFileFromText(project, "-export_type([" + text + "]).");
    return fileFromText.getAttributes().get(0);
  }

  @Nonnull
  public static PsiElement createRecordFromText(@Nonnull Project project, @Nonnull String text, @Nonnull String ... fields) {
    String fieldsText = StringUtil.join(fields, ",");
    ErlangFile fileFromText = createFileFromText(project, "-record(" + text + ", {" + fieldsText + "}).");
    return fileFromText.getRecords().get(0);
  }

  @Nonnull
  public static PsiElement createRecordFieldsFromText(@Nonnull Project project, @Nonnull String text) {
    ErlangFile fileFromText = createFileFromText(project, "-record(text{" + text + "}).");
    return fileFromText.getRecords().get(0).getTypedRecordFields();
  }

  @Nonnull
  public static PsiElement createLeafFromText(@Nonnull Project project, @Nonnull String text) {
    return createFileFromText(project, text).getFirstChild();
  }

  @Nonnull
  private static ErlangFile createFileFromText(@Nonnull Project project, @Nonnull String text) {
    return (ErlangFile) PsiFileFactory.getInstance(project).createFileFromText("a.erl", ErlangLanguage.INSTANCE, text);
  }
}
