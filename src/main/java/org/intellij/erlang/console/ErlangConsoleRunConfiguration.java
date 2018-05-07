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

import java.util.Arrays;
import java.util.Collection;

import javax.annotation.Nonnull;

import org.intellij.erlang.sdk.ErlangSdkType;
import org.jdom.Element;
import consulo.erlang.module.extension.ErlangModuleExtension;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.ModuleBasedConfiguration;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RunConfigurationModule;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.configurations.RuntimeConfigurationException;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.WriteExternalException;
import com.intellij.util.xmlb.XmlSerializer;

public final class ErlangConsoleRunConfiguration extends ModuleBasedConfiguration<RunConfigurationModule> {
  @Nonnull
  private String myWorkingDirPath;
  private String myConsoleArgs;

  public ErlangConsoleRunConfiguration(@Nonnull String name, @Nonnull Project project) {
    super(name, new RunConfigurationModule(project), ErlangConsoleRunConfigurationFactory.getInstance());
    myWorkingDirPath = project.getBasePath();
    myConsoleArgs = "";
  }

  @Nonnull
  @Override
  public SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
    return new ErlangConsoleRunConfigurationForm(getProject(), getConfigurationModule().getModule());
  }

  @Nonnull
  public RunProfileState getState(@Nonnull Executor executor, @Nonnull ExecutionEnvironment environment)
    throws ExecutionException {
    return new ErlangConsoleCommandLineState(this, environment);
  }

  @Override
  protected ModuleBasedConfiguration createInstance() {
    return new ErlangConsoleRunConfiguration(getName(), getProject());
  }

  @Override
  public Collection<Module> getValidModules() {
    return Arrays.asList(ModuleManager.getInstance(getProject()).getModules());
  }

  @Override
  public void writeExternal(@Nonnull final Element element) throws WriteExternalException {
    super.writeExternal(element);
    writeModule(element);
    XmlSerializer.serializeInto(this, element);
  }

  @Override
  public void checkConfiguration() throws RuntimeConfigurationException {
    final Module selectedModule = getConfigurationModule().getModule();
    if (selectedModule == null) {
      throw new RuntimeConfigurationException("Neither Erlang module selected nor Erlang SDK is configured ");
    }
    else {
      final Sdk moduleSdk = ModuleUtilCore.getSdk(selectedModule, ErlangModuleExtension.class);
      if (moduleSdk == null || moduleSdk.getSdkType() != ErlangSdkType.getInstance()) {
        throw new RuntimeConfigurationException("Erlang SDK is not configured for the selected module");
      }
    }
  }

  @Override
  public void readExternal(@Nonnull final Element element) throws InvalidDataException {
    super.readExternal(element);
    readModule(element);
    XmlSerializer.deserializeInto(this, element);
  }

  public void setWorkingDirPath(@Nonnull String workingDirPath) {
    myWorkingDirPath = workingDirPath;
  }

  @Nonnull
  public String getWorkingDirPath() {
    return myWorkingDirPath;
  }

  public void setConsoleArgs(@Nonnull String consoleArgs) {
    myConsoleArgs = consoleArgs;
  }

  @Nonnull
  public String getConsoleArgs() {
    return myConsoleArgs;
  }
}
