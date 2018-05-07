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

final class ErlangSdkFunctionDocProvider extends ErlangSdkDocProviderBase {
  private static final Pattern PATTERN_FUNC_BEGIN = Pattern.compile(
    "<a name=\"(.*?)\"></a><span class=\"bold_code\">.*?</span><br>");
  private static final Pattern PATTERN_BIF_BEGIN = Pattern.compile(
    "<a name=\"(.*?)\"><span class=\"bold_code\">.*?</span></a><br>");
  private static final Pattern PATTERN_END_OF_DOC = Pattern.compile("^<div class=\"footer\">$");

  @Nonnull
  private final String myFuncSignature;

  public ErlangSdkFunctionDocProvider(@Nonnull Project project, @Nonnull String functionName, int functionArity,
                                      @Nonnull VirtualFile virtualFile) {
    super(project, virtualFile);
    myFuncSignature = functionName + "-" + functionArity;
  }

  @Nonnull
  @Override
  protected String getInDocRef() {
    return "#" + myFuncSignature;
  }

  @Override
  public boolean isDocBegin(@Nonnull String line) {
    Matcher matcher = PATTERN_FUNC_BEGIN.matcher(line);
    while (matcher.find()) {
      if (matcher.group(1).equals(myFuncSignature)) {
        return true;
      }
    }
    matcher = PATTERN_BIF_BEGIN.matcher(line);
    while (matcher.find()) {
      if (matcher.group(1).equals(myFuncSignature)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean isDocEnd(@Nonnull String line) {
    return PATTERN_FUNC_BEGIN.matcher(line).find() || PATTERN_BIF_BEGIN.matcher(line).find()
      || PATTERN_END_OF_DOC.matcher(line).matches();
  }
}
