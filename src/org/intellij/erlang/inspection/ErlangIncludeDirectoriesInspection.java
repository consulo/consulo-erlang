package org.intellij.erlang.inspection;

import java.util.ArrayList;
import java.util.List;

import org.intellij.erlang.psi.ErlangFile;
import org.intellij.erlang.roots.ErlangIncludeDirectoryUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import consulo.erlang.module.extension.ErlangModuleExtension;
import com.intellij.codeInspection.InspectionManager;
import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.LocalQuickFix;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.codeInspection.ex.DisableInspectionToolAction;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.util.Condition;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.util.ArrayUtil;
import com.intellij.util.containers.ContainerUtil;

public class ErlangIncludeDirectoriesInspection extends LocalInspectionTool {
  @Nullable
  @Override
  public ProblemDescriptor[] checkFile(@NotNull final PsiFile psiFile, @NotNull final InspectionManager manager, final boolean isOnTheFly) {
    if (!(psiFile instanceof ErlangFile)) return ProblemDescriptor.EMPTY_ARRAY;
    VirtualFile file = psiFile.getVirtualFile();
    final Module module = file != null ? ModuleUtilCore.findModuleForFile(file, psiFile.getProject()) : null;
    if (module == null) return ProblemDescriptor.EMPTY_ARRAY;
    List<VirtualFile> notIncludedPaths = getIncludeFoldersNotMarkedAsIncludeDirectories(module);
    if (!notIncludedPaths.isEmpty()) {
      return createProblemDescriptors(psiFile, "Some 'include' folders are not marked as include directories.", manager, isOnTheFly);
    }
    return ProblemDescriptor.EMPTY_ARRAY;
  }

  private static ProblemDescriptor[] createProblemDescriptors(PsiFile psiFile, String message, InspectionManager manager, boolean isOnTheFly) {
    return new ProblemDescriptor[]{
      manager.createProblemDescriptor(
        psiFile, message, new LocalQuickFix[]{new ErlangIncludeDirectoriesQuickFix(true), new ErlangIncludeDirectoriesQuickFix(false)},
        ProblemHighlightType.GENERIC_ERROR_OR_WARNING, isOnTheFly, false)
    };
  }

  private static List<VirtualFile> getIncludeFoldersNotMarkedAsIncludeDirectories(Module module) {
    final VirtualFile[] includeDirectories = ErlangIncludeDirectoryUtil.getIncludeDirectories(module);
    List<VirtualFile> includeFolders = getIncludeFolders(module);
    return ContainerUtil.filter(includeFolders, new Condition<VirtualFile>() {
      @Override
      public boolean value(VirtualFile includeFolderPath) {
        return !ArrayUtil.contains(includeFolderPath, includeDirectories);
	  }
    });
  }

  private static List<VirtualFile> getIncludeFolders(Module module) {
    List<VirtualFile> includeFolders = new ArrayList<VirtualFile>();
    VirtualFile[] contentRoots = ModuleRootManager.getInstance(module).getContentRoots();
    for (VirtualFile contentRoot : contentRoots) {
      VirtualFile includeDirectory = VfsUtil.findRelativeFile(contentRoot, "include");
      if (includeDirectory != null) {
        includeFolders.add(includeDirectory);
      }
    }
    return includeFolders;
  }

  private static class ErlangIncludeDirectoriesQuickFix implements LocalQuickFix {
    private boolean myDoFix;
    private final String myName;

    protected ErlangIncludeDirectoriesQuickFix(boolean doFix) {
      myName = doFix ? "Mark folders" : "Dismiss";
      myDoFix = doFix;
    }

    @Override
    public void applyFix(@NotNull Project project, @NotNull ProblemDescriptor descriptor) {
      if (myDoFix) {
        for (Module module : ModuleManager.getInstance(project).getModules()) {
          doFix(module);
        }
      }
      else {
        new DisableInspectionToolAction(new ErlangIncludeDirectoriesInspection()).invoke(project, null, descriptor.getPsiElement().getContainingFile());
      }
    }

    @NotNull
    @Override
    public String getName() {
      return myName;
    }

    @NotNull
    @Override
    public String getFamilyName() {
      return myName;
    }

    private static void doFix(@NotNull Module module) {
      if (ModuleUtilCore.getExtension(module, ErlangModuleExtension.class) == null) return;
      List<VirtualFile> includeFolders = getIncludeFoldersNotMarkedAsIncludeDirectories(module);
      for (VirtualFile includeFolder : includeFolders) {
        ErlangIncludeDirectoryUtil.markAsIncludeDirectory(module, includeFolder);
      }
    }
  }
}
