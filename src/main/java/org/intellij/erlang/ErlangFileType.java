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
import javax.annotation.Nullable;

import com.intellij.openapi.fileTypes.LanguageFileType;
import consulo.ui.image.Image;

public class ErlangFileType extends LanguageFileType {
  public static ErlangFileType MODULE = new ErlangFileType();
  public static HrlFileType HEADER = new HrlFileType();
  public static AppFileType APP = new AppFileType();
  public static ErlangTermsFileType TERMS = new ErlangTermsFileType();

  protected ErlangFileType() {
    super(ErlangLanguage.INSTANCE);
  }

  @Nonnull
  @Override
  public String getName() {
    return "Erlang";
  }

  @Nonnull
  @Override
  public String getDescription() {
    return "Erlang";
  }

  @Nonnull
  @Override
  public String getDefaultExtension() {
    return "erl";
  }

  @Override
  public Image getIcon() {
    return ErlangIcons.FILE;
  }

  public static class HrlFileType extends ErlangFileType {
    @Nonnull
    @Override
    public String getName() {
      return "Erlang Header";
    }

    @Nonnull
    @Override
    public String getDescription() {
      return "Erlang/OTP Header File";
    }

    @Nonnull
    @Override
    public String getDefaultExtension() {
      return "hrl";
    }

    @Override
    public Image getIcon() {
      return ErlangIcons.HEADER;
    }
  }

  public static class AppFileType extends ErlangFileType {
    @Nonnull
    @Override
    public String getName() {
      return "Erlang/OTP app";
    }

    @Nonnull
    @Override
    public String getDescription() {
      return "Erlang/OTP Application Resource File";
    }

    @Nonnull
    @Override
    public String getDefaultExtension() {
      return "app";
    }

    @Override
    public Image getIcon() {
      return ErlangIcons.OTP_APP_RESOURCE;
    }
  }

  public static class ErlangTermsFileType extends ErlangFileType {
    @Nonnull
    @Override
    public String getName() {
      return "Erlang Terms";
    }

    @Nonnull
    @Override
    public String getDescription() {
      return "Erlang Terms File";
    }

    @Nonnull
    @Override
    public String getDefaultExtension() {
      return "config";
    }

    @Override
    public Image getIcon() {
      return ErlangIcons.TERMS;
    }
  }

  @Nullable
  public static ErlangFileType getFileType(String filename) {
    if (filename == null) return null;
    if (filename.endsWith(MODULE.getDefaultExtension())) return MODULE;
    if (filename.endsWith(HEADER.getDefaultExtension())) return HEADER;
    if (filename.endsWith(APP.getDefaultExtension())) return APP;
    if (filename.endsWith(TERMS.getDefaultExtension())) return TERMS;
    return null;
  }

  @Nullable
  public static Image getIconForFile(String filename) {
    ErlangFileType fileType = getFileType(filename);
    return fileType == null ? null : fileType.getIcon();
  }
}
