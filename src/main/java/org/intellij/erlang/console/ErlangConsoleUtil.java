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

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.Processor;
import consulo.compiler.ModuleCompilerPathsManager;
import consulo.erlang.module.extension.ErlangModuleExtension;
import consulo.roots.impl.ProductionContentFolderTypeProvider;
import consulo.roots.impl.TestContentFolderTypeProvider;

public final class ErlangConsoleUtil {
  public static final String EUNIT_FAILURE_PATH = "\\[\\{file,\"" + FileReferenceFilter.PATH_MACROS + "\"\\},\\{line," + FileReferenceFilter.LINE_MACROS + "\\}\\]";
  public static final String EUNIT_ERROR_PATH = FileReferenceFilter.PATH_MACROS + ", line " + FileReferenceFilter.LINE_MACROS;
  public static final String COMPILATION_ERROR_PATH = FileReferenceFilter.PATH_MACROS + ":" + FileReferenceFilter.LINE_MACROS;

  private ErlangConsoleUtil() {
  }

  public static void attachFilters(@Nonnull Project project, @Nonnull ConsoleView consoleView) {
    consoleView.addMessageFilter(new FileReferenceFilter(project, COMPILATION_ERROR_PATH));
    consoleView.addMessageFilter(new FileReferenceFilter(project, EUNIT_ERROR_PATH));
    consoleView.addMessageFilter(new FileReferenceFilter(project, EUNIT_FAILURE_PATH));
  }

  @Nonnull
  public static List<String> getCodePath(@Nonnull Module module, boolean forTests) {
    return getCodePath(module.getProject(), module, forTests);
  }

  @Nonnull
  public static List<String> getCodePath(@Nonnull Project project, @Nullable Module module, boolean useTestOutputPath) {
    final Set<Module> codePathModules = new HashSet<Module>();
    if (module != null) {
      final ModuleRootManager moduleRootMgr = ModuleRootManager.getInstance(module);
      moduleRootMgr.orderEntries().recursively().forEachModule(new Processor<Module>() {
        @Override
        public boolean process(@Nonnull Module dependencyModule) {
          codePathModules.add(dependencyModule);
          return true;
        }
      });
    }
    else {
      codePathModules.addAll(Arrays.asList(ModuleManager.getInstance(project).getModules()));
    }

    final List<String> codePath = new ArrayList<String>(codePathModules.size() * 2);
    for (Module codePathModule : codePathModules) {
      final ModuleRootManager moduleRootManager = ModuleRootManager.getInstance(codePathModule);
      final ModuleCompilerPathsManager compilerModuleExt = ModuleCompilerPathsManager.getInstance(codePathModule);
      final VirtualFile buildOutput = useTestOutputPath && codePathModule == module ?
        getCompilerOutputPathForTests(compilerModuleExt) : 
        compilerModuleExt.getCompilerOutput(ProductionContentFolderTypeProvider.getInstance());
      if (buildOutput != null) {
        codePath.add("-pa");
        codePath.add(buildOutput.getCanonicalPath());
      }
      for (VirtualFile contentRoot : ModuleRootManager.getInstance(codePathModule).getContentRoots()) {
        codePath.add("-pa");
        codePath.add(contentRoot.getPath());
      }
    }

    return codePath;
  }

  @Nullable
  private static VirtualFile getCompilerOutputPathForTests(ModuleCompilerPathsManager module) {
    final VirtualFile testPath = module.getCompilerOutput(TestContentFolderTypeProvider.getInstance());
    return testPath == null || !testPath.exists() ? module.getCompilerOutput(ProductionContentFolderTypeProvider.getInstance()) : testPath;
  }

  @Nonnull
  static String getWorkingDirPath(@Nonnull Project project, @Nonnull String workingDirPath) {
    if (workingDirPath.isEmpty()) {
      return project.getBasePath();
    }
    return workingDirPath;
  }

  @Nonnull
  static String getErlPath(@Nonnull Project project, @Nullable Module module) throws ExecutionException {
    Sdk sdk = module != null ? ModuleUtilCore.getSdk(module, ErlangModuleExtension.class) : null;

    if (sdk == null) {
      throw new ExecutionException("Erlang SDK is not configured");
    }
    return sdk.getHomePath() + File.separator + "bin" + File.separator + "erl";
  }
}

