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

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NonNls;
import com.intellij.openapi.fileTypes.FileNameMatcher;
import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import com.intellij.openapi.util.text.StringUtil;

public class ErlangFileTypeFactory extends FileTypeFactory {
  private static final class ExtensionFileNameMatcher implements FileNameMatcher {
    private final String myDotExtension;

    private ExtensionFileNameMatcher(@NonNls @Nonnull String extension) {
      myDotExtension = "." + extension;
    }

    @Override
    public boolean accept(@NonNls @Nonnull CharSequence fileName) {
      return StringUtil.endsWith(fileName, myDotExtension);
    }

    @Nonnull
    @Override
    public String getPresentableString() {
      return "*" + myDotExtension;
    }
  }

  @Override
  public void createFileTypes(@Nonnull FileTypeConsumer fileTypeConsumer) {
    fileTypeConsumer.consume(ErlangFileType.MODULE);
    fileTypeConsumer.consume(ErlangFileType.HEADER);
    fileTypeConsumer.consume(ErlangFileType.APP,
      new ExtensionFileNameMatcher(ErlangFileType.APP.getDefaultExtension()),
      new ExtensionFileNameMatcher(ErlangFileType.APP.getDefaultExtension() + ".src"));
    fileTypeConsumer.consume(ErlangFileType.TERMS, 
      new ExtensionFileNameMatcher("routes"), 
      new ExtensionFileNameMatcher("config"),
      new ExtensionFileNameMatcher("rel")
    );
  }
}
