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

package org.intellij.erlang.console;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;

final class ErlangConsoleViewDirectory {
  private static final ErlangConsoleViewDirectory outInstance = new ErlangConsoleViewDirectory();

  private Set<ErlangConsoleView> consoleViews = new HashSet<ErlangConsoleView>();

  private ErlangConsoleViewDirectory() {
  }

  public static ErlangConsoleViewDirectory getInstance() {
    return outInstance;
  }

  public synchronized void addConsole(@Nonnull ErlangConsoleView console) {
    consoleViews.add(console);
  }

  public synchronized void delConsole(@Nonnull ErlangConsoleView console) {
    consoleViews.remove(console);
  }

  @Nullable
  public synchronized ErlangConsoleView getConsole(@Nonnull Editor editor) {
    for (ErlangConsoleView consoleView : consoleViews) {
      if (editor == consoleView.getConsoleEditor()) {
        return consoleView;
      }
    }
    return null;
  }

  @Nullable
  public synchronized ErlangConsoleView getConsole(@Nonnull Project project) {
    for (ErlangConsoleView consoleView : consoleViews) {
      if (project == consoleView.getProject()) {
        return consoleView;
      }
    }
    return null;
  }
}
