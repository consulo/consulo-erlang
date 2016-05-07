package org.intellij.erlang.eunit;

import java.util.Collection;

import org.jetbrains.annotations.Nullable;
import consulo.erlang.rebar.module.RebarModuleUtil;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.search.FilenameIndex;

public class ErlangTestRunConfigProducersUtil {
  private ErlangTestRunConfigProducersUtil() {
  }

  public static boolean shouldProduceEunitTestRunConfiguration(@Nullable Project project, @Nullable Module module) {
    return !shouldProduceRebarTestRunConfiguration(project, module);
  }

  public static boolean shouldProduceRebarTestRunConfiguration(@Nullable Project project, @Nullable Module module) {
    if (project == null || module == null) return false;
    if (StringUtil.isEmpty(RebarModuleUtil.getRebarPath(module))) return false;
    Collection<VirtualFile> configs = FilenameIndex.getVirtualFilesByName(project, "rebar.config", module.getModuleContentScope());
    return !configs.isEmpty();
  }
}
