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

package org.intellij.erlang.psi;

import com.intellij.psi.PsiFile;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.*;

public interface ErlangFile extends PsiFile {
  @Nullable
  ErlangModule getModule();

  @Nonnull
  List<ErlangRule> getRules();

  @Nonnull
  List<ErlangAttribute> getAttributes();

  @Nullable
  ErlangCallbackSpec getCallbackByName(@Nonnull String fullName);

  @Nonnull
  List<ErlangFunction> getFunctions();

  @Nullable
  ErlangFunction getFunction(@Nonnull String name, final int argsCount);

  @Nonnull
  Collection<ErlangFunction> getFunctionsByName(@Nonnull String name);

  @Nonnull
  List<ErlangRecordDefinition> getRecords();

  @Nonnull
  List<ErlangMacrosDefinition> getMacroses();

  @Nullable
  ErlangMacrosDefinition getMacros(@Nonnull String name);

  @Nonnull
  List<ErlangTypeDefinition> getTypes();

  @Nullable
  ErlangTypeDefinition getType(@Nonnull String name);

  @Nullable
  ErlangRecordDefinition getRecord(String name);

  @Nonnull
  List<ErlangInclude> getIncludes();

  @Nonnull
  List<ErlangIncludeLib> getIncludeLibs();

  @Nonnull
  List<ErlangBehaviour> getBehaviours();

  @Nonnull
  List<ErlangSpecification> getSpecifications();

  @Nonnull
  Collection<ErlangFunction> getExportedFunctions();

  boolean isExported(@Nonnull String signature);

  boolean isExportedAll();

  @Nonnull
  ArrayList<ErlangImportFunction> getImportedFunctions();

  @Nonnull
  Map<String, ErlangCallbackSpec> getCallbackMap();

  void addDeclaredParseTransforms(@Nonnull Set<String> parseTransforms);
}
