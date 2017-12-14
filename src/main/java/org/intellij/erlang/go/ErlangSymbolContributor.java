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

package org.intellij.erlang.go;

import java.util.Collection;
import java.util.List;

import org.intellij.erlang.ErlangStructureViewFactory;
import org.intellij.erlang.psi.ErlangNamedElement;
import org.intellij.erlang.stubs.index.ErlangAllNameIndex;
import org.jetbrains.annotations.NotNull;
import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.util.ArrayUtil;
import com.intellij.util.containers.ContainerUtil;

public class ErlangSymbolContributor implements ChooseByNameContributor {
  @NotNull
  @Override
  public String[] getNames(Project project, boolean includeNonProjectItems) {
    return ArrayUtil.toStringArray(StubIndex.getInstance().getAllKeys(ErlangAllNameIndex.KEY, project));
  }

  @NotNull
  @Override
  public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
    GlobalSearchScope scope = includeNonProjectItems ? GlobalSearchScope.allScope(project) : GlobalSearchScope.projectScope(project);
    Collection<ErlangNamedElement> result = StubIndex.getInstance().get(ErlangAllNameIndex.KEY, name, project, scope);
    List<NavigationItem> items = ContainerUtil.newArrayListWithCapacity(result.size());
    for (final ErlangNamedElement element : result) {
      items.add(new ErlangStructureViewFactory.Element(element) {
        @Override
        public String getLocationString() {
          return "(in " + element.getContainingFile().getName() + ")";
        }
      });
    }
    return items.toArray(new NavigationItem[items.size()]);
  }
}
