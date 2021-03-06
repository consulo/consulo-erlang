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

package org.intellij.erlang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.impl.source.resolve.FileContextUtil;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import consulo.util.collection.primitive.objects.ObjectIntMap;
import consulo.util.collection.primitive.objects.ObjectMaps;
import consulo.util.dataholder.Key;
import org.intellij.erlang.ErlangFileType;
import org.intellij.erlang.ErlangTypes;
import org.intellij.erlang.psi.impl.ErlangPsiImplUtil;

import javax.annotation.Nonnull;

public class ErlangParserUtil extends GeneratedParserUtilBase {
  public static boolean isApplicationLanguage(PsiBuilder builder_, @SuppressWarnings("UnusedParameters") int level) {
    PsiFile file = builder_.getUserData(FileContextUtil.CONTAINING_FILE_KEY);
    assert file != null;
    return isApplicationConfigFileType(file);
  }

  public static boolean isConsole(PsiBuilder builder_, @SuppressWarnings("UnusedParameters") int level) {
    PsiFile file = builder_.getUserData(FileContextUtil.CONTAINING_FILE_KEY);
    assert file != null;
    return isConsole(file);
  }

  public static boolean isConsole(@Nonnull PsiFile file) {
    return file.getOriginalFile().getUserData(ErlangPsiImplUtil.ERLANG_CONSOLE) != null;
  }

  public static boolean isApplicationConfigFileType(@Nonnull PsiFile file) {
    FileType fileType = file.getViewProvider().getVirtualFile().getFileType();
    return fileType == ErlangFileType.APP || fileType == ErlangFileType.TERMS ||
      (ApplicationManager.getApplication().isUnitTestMode() && (fileType.getDefaultExtension().equals("app") || fileType.getDefaultExtension().equals("config")));
  }

  private static final Key<ObjectIntMap<String>> MODES_KEY = Key.create("MODES_KEY");
  private static ObjectIntMap<String> getParsingModes(PsiBuilder builder_) {
    ObjectIntMap<String> flags = builder_.getUserData(MODES_KEY);
    if (flags == null) builder_.putUserData(MODES_KEY, flags = ObjectMaps.newObjectIntHashMap());
    return flags;
  }

  public static boolean isModeOn(PsiBuilder builder_, @SuppressWarnings("UnusedParameters") int level, String mode) {
    return getParsingModes(builder_).getInt(mode) > 0;
  }

  public static boolean isModeOff(PsiBuilder builder_, @SuppressWarnings("UnusedParameters") int level, String mode) {
    return getParsingModes(builder_).getInt(mode) == 0;
  }

  public static boolean enterMode(PsiBuilder builder_, @SuppressWarnings("UnusedParameters") int level, String mode) {
    ObjectIntMap<String> flags = getParsingModes(builder_);
    if(flags.containsKey(mode))
        flags.putInt(mode, flags.getInt(mode) + 1);
    else
        flags.putInt(mode, 1);
    return true;
  }

  public static boolean exitMode(PsiBuilder builder_, @SuppressWarnings("UnusedParameters") int level, String mode) {
    ObjectIntMap<String> flags = getParsingModes(builder_);
    int count = flags.getInt(mode);
    if (count == 1) flags.remove(mode);
    else if (count > 1) flags.putInt(mode, count -1);
    else builder_.error("Could not exit inactive '" + mode + "' mode at offset " + builder_.getCurrentOffset());
    return true;
  }

  @SuppressWarnings("MethodOverridesStaticMethodOfSuperclass")
  public static PsiBuilder adapt_builder_(IElementType root, PsiBuilder builder, PsiParser parser, TokenSet[] tokenSets) {
    PsiBuilder result = GeneratedParserUtilBase.adapt_builder_(root, builder, parser, tokenSets);
    ErrorState.get(result).altMode = true;
    return result;
  }
  
  @SuppressWarnings("UnusedParameters")
  public static boolean eofOrSpace(PsiBuilder builder_, int level_) {
    if (builder_.eof()) return true;
    IElementType one = builder_.rawLookup(1);
    IElementType two = builder_.rawLookup(2);
    if (one == TokenType.WHITE_SPACE && (two == ErlangTypes.ERL_DOT || two == null) || one == null && builder_.getTokenType() == ErlangTypes.ERL_DOT) {
      builder_.remapCurrentToken(TokenType.ERROR_ELEMENT);
      return true;
    }
    return false;
  }
}