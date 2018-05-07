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

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.util.PsiTreeUtil;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class ResolveUtil {
  private ResolveUtil() {
  }

  public static boolean treeWalkUp(@Nullable PsiElement place, @Nonnull PsiScopeProcessor processor) {
    PsiElement lastParent = null;
    PsiElement run = place;
    while (run != null) {
      if (place != run && !run.processDeclarations(processor, ResolveState.initial(), lastParent, place)) return false;
      lastParent = run;
      run = run.getParent();
    }
    return true;
  }

  public static boolean processChildren(@Nonnull PsiElement element,
                                        @Nonnull PsiScopeProcessor processor,
                                        @Nonnull ResolveState substitutor,
                                        @Nullable PsiElement lastParent,
                                        @Nonnull PsiElement place) {
    PsiElement run = lastParent == null ? element.getLastChild() : lastParent.getPrevSibling();
    while (run != null) {
      if (PsiTreeUtil.findCommonParent(place, run) != run && !run.processDeclarations(processor, substitutor, null, place)) {
        return false;
      }
      run = run.getPrevSibling();
    }
    return true;
  }
}
