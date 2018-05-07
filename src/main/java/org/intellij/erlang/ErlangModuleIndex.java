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

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import org.intellij.erlang.psi.ErlangFile;
import org.intellij.erlang.psi.ErlangModule;

import javax.annotation.Nullable;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VfsUtilCore;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.Function;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.indexing.DataIndexer;
import com.intellij.util.indexing.FileBasedIndex;
import com.intellij.util.indexing.FileContent;
import com.intellij.util.indexing.ID;
import com.intellij.util.indexing.ScalarIndexExtension;
import com.intellij.util.io.EnumeratorStringDescriptor;
import com.intellij.util.io.KeyDescriptor;

public class ErlangModuleIndex extends ScalarIndexExtension<String> {
  public static final ID<String, Void> ERLANG_MODULE_INDEX = ID.create("ErlangModuleIndex");
  private static final int INDEX_VERSION = 1;
  public static final FileBasedIndex.InputFilter ERLANG_MODULE_FILTER = new FileBasedIndex.InputFilter() {
    @Override
    public boolean acceptInput(Project project, VirtualFile file) {
      return file.getFileType() == ErlangFileType.MODULE;
    }
  };

  private DataIndexer<String, Void, FileContent> myDataIndexer = new MyDataIndexer();

  @Nonnull
  @Override
  public ID<String, Void> getName() {
    return ERLANG_MODULE_INDEX;
  }

  @Override
  public int getVersion() {
    return INDEX_VERSION;
  }

  @Nonnull
  @Override
  public DataIndexer<String, Void, FileContent> getIndexer() {
    return myDataIndexer;
  }

  @Override
  public KeyDescriptor<String> getKeyDescriptor() {
    return new EnumeratorStringDescriptor();
  }

  @Override
  public FileBasedIndex.InputFilter getInputFilter() {
    return ERLANG_MODULE_FILTER;
  }

  @Override
  public boolean dependsOnFileContent() {
    return false;
  }

  public static Collection<String> getNames(@Nonnull Project project) {
    return FileBasedIndex.getInstance().getAllKeys(ERLANG_MODULE_INDEX, project);
  }

  @Nonnull
  public static List<ErlangModule> getModulesByName(@Nonnull Project project, @Nonnull String name, @Nonnull GlobalSearchScope searchScope) {
    return getByName(project, name, searchScope, new Function<ErlangFile, ErlangModule>() {
      @Nullable
      @Override
      public ErlangModule fun(ErlangFile erlangFile) {
        return erlangFile.getModule();
      }
    });
  }

  @Nonnull
  public static List<ErlangFile> getFilesByName(@Nonnull Project project, @Nonnull String name, @Nonnull GlobalSearchScope searchScope) {
    return getByName(project, name, searchScope, new Function<ErlangFile, ErlangFile>() {
      @Override
      public ErlangFile fun(ErlangFile erlangFile) {
        return erlangFile;
      }
    });
  }

  private static <T> List<T> getByName(@Nonnull Project project, @Nonnull String name, @Nonnull GlobalSearchScope searchScope, final Function<ErlangFile, T> psiMapper) {
    final PsiManager psiManager = PsiManager.getInstance(project);
    List<VirtualFile> virtualFiles = getVirtualFilesByName(project, name, searchScope);
    return ContainerUtil.mapNotNull(virtualFiles, new Function<VirtualFile, T>() {
      @Nullable
      @Override
      public T fun(VirtualFile virtualFile) {
        PsiFile psiFile = psiManager.findFile(virtualFile);
        return psiFile instanceof ErlangFile ? psiMapper.fun((ErlangFile)psiFile) : null;
      }
    });
  }

  private static List<VirtualFile> getVirtualFilesByName(@Nonnull Project project, @Nonnull String name, @Nonnull GlobalSearchScope searchScope) {
    final ProjectFileIndex projectFileIndex = ProjectRootManager.getInstance(project).getFileIndex();
    Collection<VirtualFile> files = FileBasedIndex.getInstance().getContainingFiles(ERLANG_MODULE_INDEX, name, searchScope);
    ArrayList<VirtualFile> filesList = new ArrayList<VirtualFile>(files);
    Collections.sort(filesList, new MyProjectFilesComparator(projectFileIndex, searchScope));
    return filesList;
  }

  private static final class MyProjectFilesComparator implements Comparator<VirtualFile> {
    private final ProjectFileIndex myProjectFileIndex;
    private final GlobalSearchScope mySearchScope;

    MyProjectFilesComparator(ProjectFileIndex pfi, GlobalSearchScope searchScope) {
      myProjectFileIndex = pfi;
      mySearchScope = searchScope;
    }

    @Override
    public int compare(VirtualFile f1, VirtualFile f2) {
      // according to http://www.erlang.org/doc/man/code.html, modules that belong to
      // 'kernel' and 'stdlib' applications always appear before any user-defined modules
      if (isKernelOrStdlibModule(f1)) return -1;
      if (isKernelOrStdlibModule(f2)) return 1;

      boolean f1IsInSource = isInSource(f1);
      boolean f2IsInSource = isInSource(f2);
      if (f1IsInSource != f2IsInSource) return f1IsInSource ? -1 : 1;

      boolean f1IsHidden = isUnderHiddenDirectory(f1);
      boolean f2IsHidden = isUnderHiddenDirectory(f2);
      if (f1IsHidden != f2IsHidden) return f1IsHidden ? 1 : -1;

      boolean f1IsInLibrary = isInLibrary(f1);
      boolean f2IsInLibrary = isInLibrary(f2);
      if (f1IsInLibrary != f2IsInLibrary) return f1IsInLibrary ? -1 : 1;

      return f1.getPath().length() - f2.getPath().length();
    }

    private boolean isKernelOrStdlibModule(VirtualFile file) {
      VirtualFile kernelAppDir = ErlangApplicationIndex.getApplicationDirectoryByName("kernel", mySearchScope);
      if (kernelAppDir != null && VfsUtilCore.isAncestor(kernelAppDir, file, true)) return true;
      VirtualFile stdlibAppDir = ErlangApplicationIndex.getApplicationDirectoryByName("stdlib", mySearchScope);
      return stdlibAppDir != null && VfsUtilCore.isAncestor(stdlibAppDir, file, true);
    }

    private boolean isUnderHiddenDirectory(VirtualFile f) {
      VirtualFile contentRoot = myProjectFileIndex.getContentRootForFile(f);
      while (f != null && (contentRoot == null || VfsUtilCore.isAncestor(contentRoot, f, true))) {
        File ioFile = VfsUtilCore.virtualToIoFile(f);
        if (ioFile.isHidden()) return true;
        f = f.getParent();
      }
      return false;
    }

    private boolean isInLibrary(VirtualFile file) {
      return myProjectFileIndex.isInLibraryClasses(file) || myProjectFileIndex.isInLibrarySource(file);
    }

    private boolean isInSource(VirtualFile file) {
      return myProjectFileIndex.isInSource(file);
    }
  }

  private static class MyDataIndexer implements DataIndexer<String, Void, FileContent> {
    @Override
    @Nonnull
    public Map<String, Void> map(final FileContent inputData) {
      return Collections.singletonMap(inputData.getFile().getNameWithoutExtension(), null);
    }
  }
}
