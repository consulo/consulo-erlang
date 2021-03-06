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

package org.intellij.erlang.dialyzer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.intellij.openapi.components.*;
import com.intellij.openapi.project.Project;
import com.intellij.util.xmlb.XmlSerializerUtil;

@State(  name = "DialyzerSettings", storages = @Storage(file = StoragePathMacros.PROJECT_CONFIG_DIR + "/dialyzer.xml"))
public final class DialyzerSettings implements PersistentStateComponent<DialyzerSettings> {
  @Nonnull
  private String myCurrentPltPath = "";

  @Nonnull
  public static DialyzerSettings getInstance(@Nonnull Project project) {
    final DialyzerSettings persisted = ServiceManager.getService(project, DialyzerSettings.class);
    return persisted != null ? persisted : new DialyzerSettings();
  }

  @Nullable
  @Override
  public DialyzerSettings getState() {
    return this;
  }

  @Override
  public void loadState(@Nonnull DialyzerSettings dialyzerSettings) {
    XmlSerializerUtil.copyBean(dialyzerSettings, this);
  }

  @Nonnull
  public String getCurrentPltPath() {
    return myCurrentPltPath;
  }

  public void setCurrentPltPath(@Nonnull String currentPltPath) {
    myCurrentPltPath = currentPltPath;
  }

  @Override
  public String toString() {
    return "DialyzerSettings(myCurrentPltPath='" + myCurrentPltPath + "')";
  }
}