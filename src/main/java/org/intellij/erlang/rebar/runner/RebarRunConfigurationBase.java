package org.intellij.erlang.rebar.runner;

import javax.annotation.Nonnull;

import org.jdom.Element;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.configurations.RuntimeConfiguration;
import com.intellij.execution.configurations.RuntimeConfigurationException;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.runners.RunConfigurationWithSuppressedDefaultRunAction;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.WriteExternalException;
import com.intellij.util.xmlb.XmlSerializer;

public abstract class RebarRunConfigurationBase extends RuntimeConfiguration implements RunConfigurationWithSuppressedDefaultRunAction {
  @Nonnull
  private String myCommand = "";
  private boolean mySkipDependencies = false;

  protected RebarRunConfigurationBase(@Nonnull String name, @Nonnull Project project, @Nonnull ConfigurationFactory configurationFactory) {
    super(name, project, configurationFactory);
  }

  @Nonnull
  @Override
  public SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
    return new RebarRunConfigurationEditorForm();
  }

  @Nonnull
  public RunProfileState getState(@Nonnull Executor executor, @Nonnull ExecutionEnvironment env) throws ExecutionException {
    return new RebarRunningState(env, this);
  }

  @Override
  public void checkConfiguration() throws RuntimeConfigurationException {
    // TODO parse rebar command line to check if it is valid
  }

  public void writeExternal(@Nonnull final Element element) throws WriteExternalException {
    super.writeExternal(element);
    XmlSerializer.serializeInto(this, element);
  }

  public void readExternal(@Nonnull final Element element) throws InvalidDataException {
    super.readExternal(element);
    XmlSerializer.deserializeInto(this, element);
  }

  @Nonnull
  public String getCommand() {
    return myCommand;
  }

  public void setCommand(@Nonnull String command) {
    myCommand = command;
  }

  public boolean isSkipDependencies() {
    return mySkipDependencies;
  }

  public void setSkipDependencies(boolean skipDeps) {
    mySkipDependencies = skipDeps;
  }
}