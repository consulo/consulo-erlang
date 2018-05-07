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

import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.ElementDescriptionUtil;
import com.intellij.psi.PsiElement;
import com.intellij.usageView.UsageViewLongNameLocation;
import com.intellij.usageView.UsageViewNodeTextLocation;
import com.intellij.usageView.UsageViewTypeLocation;
import org.intellij.erlang.psi.*;

public class ErlangFindUsagesProvider implements FindUsagesProvider {
  @Override
  public WordsScanner getWordsScanner() {
    return null;
    // todo
    //new DefaultWordsScanner(new ErlangLexer(), TokenSet.create(ErlangTypes.ERL_ATOM, ErlangTypes.ERL_VAR), ErlangParserDefinition.COMMENTS, TokenSet.create(ErlangTypes.ERL_STRING));
  }

  @Override
  public boolean canFindUsagesFor(@Nonnull PsiElement o) {
    return o instanceof ErlangFunction || o instanceof ErlangQVar
      || o instanceof ErlangRecordDefinition || o instanceof ErlangModule
      || o instanceof ErlangMacrosDefinition || o instanceof ErlangTypedExpr
      || o instanceof ErlangTypeDefinition || o instanceof ErlangQAtom
      ;
  }

  @Override
  public String getHelpId(@Nonnull PsiElement psiElement) {
    return "reference.dialogs.findUsages.other"; // todo: after 13.1 use HelpID
  }

  @Nonnull
  @Override
  public String getType(@Nonnull PsiElement element) {
    return ElementDescriptionUtil.getElementDescription(element, UsageViewTypeLocation.INSTANCE);
  }

  @Nonnull
  @Override
  public String getDescriptiveName(@Nonnull PsiElement element) {
    return ElementDescriptionUtil.getElementDescription(element, UsageViewLongNameLocation.INSTANCE);
  }

  @Nonnull
  @Override
  public String getNodeText(@Nonnull PsiElement element, boolean useFullName) {
    return ElementDescriptionUtil.getElementDescription(element, UsageViewNodeTextLocation.INSTANCE);
  }
}
