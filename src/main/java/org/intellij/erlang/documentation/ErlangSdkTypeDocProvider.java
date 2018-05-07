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

package org.intellij.erlang.documentation;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import javax.annotation.Nonnull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class ErlangSdkTypeDocProvider extends ErlangSdkDocProviderBase {
  private static final Pattern PATTERN_TYPE_BEGIN = Pattern.compile(
    "^      <span class=\"bold_code\"><a name=\"type-(.*?)\">.*?</span><br></p>$");
  private static final Pattern PATTERN_FUNC_BEGIN = Pattern.compile("^  <h3>EXPORTS</h3>$");

  @Nonnull
  private final String myTypeName;

  public ErlangSdkTypeDocProvider(@Nonnull Project project, @Nonnull VirtualFile virtualFile, @Nonnull String typeName) {
    super(project, virtualFile);
    myTypeName = typeName;
  }

  @Nonnull
  @Override
  protected String getInDocRef() {
    return "#type-" + myTypeName;
  }

  @Override
  protected boolean isDocBegin(@Nonnull String line) {
    final Matcher matcher = PATTERN_TYPE_BEGIN.matcher(line);
    return (matcher.matches() && matcher.group(1).equals(myTypeName));
  }

  @Override
  protected boolean isDocEnd(@Nonnull String line) {
    return PATTERN_TYPE_BEGIN.matcher(line).matches() || PATTERN_FUNC_BEGIN.matcher(line).matches();
  }
}
