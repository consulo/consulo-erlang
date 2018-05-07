package org.intellij.erlang.rebar.runner;

import javax.annotation.Nonnull;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.project.Project;

public class RebarEunitRunConfiguration extends RebarRunConfigurationBase {
  protected RebarEunitRunConfiguration(@Nonnull Project project, @Nonnull String name) {
    super(name, project, RebarEunitRunConfigurationFactory.getInstance());
    setCommand("eunit");
    setSkipDependencies(true);
  }

  @Nonnull
  @Override
  public RunProfileState getState(@Nonnull Executor executor, @Nonnull ExecutionEnvironment env) throws ExecutionException {
    return new RebarEunitRunningState(env, this);
  }
}