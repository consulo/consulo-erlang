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

package org.intellij.erlang.debugger.remote.ui;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.intellij.erlang.debugger.remote.ErlangRemoteDebugRunConfiguration;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.roots.ui.configuration.ModulesCombobox;

public class ErlangRemoteDebugConfigurationEditorForm extends SettingsEditor<ErlangRemoteDebugRunConfiguration> {
  private JPanel myComponent;
  private ModulesCombobox myModuleComboBox;
  private JTextField myNodeTextField;
  private JTextField myCookieTextField;

  @Override
  protected void resetEditorFrom(ErlangRemoteDebugRunConfiguration configuration) {
    myModuleComboBox.fillModules(configuration.getProject());
    myModuleComboBox.setSelectedModule(configuration.getConfigurationModule().getModule());
    myNodeTextField.setText(configuration.getErlangNode());
    myCookieTextField.setText(configuration.getCookie());
  }

  @Override
  protected void applyEditorTo(ErlangRemoteDebugRunConfiguration configuration) throws ConfigurationException {
    configuration.setModule(myModuleComboBox.getSelectedModule());
    configuration.setErlangNode(myNodeTextField.getText());
    configuration.setCookie(myCookieTextField.getText());
  }

  @NotNull
  @Override
  protected JComponent createEditor() {
    return myComponent;
  }
}
