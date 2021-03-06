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

package org.intellij.erlang;

import javax.annotation.Nonnull;

import org.intellij.erlang.parser.ErlangLexer;
import org.intellij.erlang.parser.ErlangParser;
import org.intellij.erlang.psi.ErlangTokenType;
import org.intellij.erlang.psi.impl.ErlangFileImpl;
import org.intellij.erlang.stubs.types.ErlangFileElementType;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import consulo.lang.LanguageVersion;

public class ErlangParserDefinition implements ParserDefinition {
  public static final TokenSet WS = TokenSet.create(TokenType.WHITE_SPACE);
  public static final IElementType ERL_SHEBANG = new ErlangTokenType("ERL_SHEBANG");
  public static final IElementType ERL_COMMENT = new ErlangTokenType("ERL_LINE_COMMENT");
  public static final IElementType ERL_FUNCTION_DOC_COMMENT = new ErlangTokenType("function_doc_comment");
  public static final IElementType ERL_MODULE_DOC_COMMENT = new ErlangTokenType("module_doc_comment");
  public static final TokenSet COMMENTS = TokenSet.create(ERL_COMMENT, ERL_FUNCTION_DOC_COMMENT, ERL_MODULE_DOC_COMMENT, ERL_SHEBANG);
  public static final TokenSet LITERALS = TokenSet.create(ErlangTypes.ERL_STRING);

  @Nonnull
  @Override
  public Lexer createLexer(@Nonnull LanguageVersion languageVersion) {
    return new ErlangLexer();
  }

  @Nonnull
  @Override
  public PsiParser createParser( @Nonnull LanguageVersion languageVersion) {
    return new ErlangParser();
  }

  @Nonnull
  @Override
  public IFileElementType getFileNodeType() {
    return ErlangFileElementType.INSTANCE;
  }

  @Nonnull
  @Override
  public TokenSet getWhitespaceTokens(@Nonnull LanguageVersion languageVersion) {
    return WS;
  }

  @Nonnull
  @Override
  public TokenSet getCommentTokens(@Nonnull LanguageVersion languageVersion) {
    return COMMENTS;
  }

  @Nonnull
  @Override
  public TokenSet getStringLiteralElements(@Nonnull LanguageVersion languageVersion) {
    return LITERALS;
  }

  @Nonnull
  @Override
  public PsiElement createElement(ASTNode astNode) {
    return ErlangTypes.Factory.createElement(astNode);
  }

  @Override
  public PsiFile createFile(FileViewProvider fileViewProvider) {
    return new ErlangFileImpl(fileViewProvider);
  }

  @Override
  public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode astNode, ASTNode astNode1) {
    return SpaceRequirements.MAY;
  }
}
