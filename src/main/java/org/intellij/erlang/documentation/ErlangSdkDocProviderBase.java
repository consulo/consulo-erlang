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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.intellij.codeInsight.documentation.DocumentationManagerProtocol;
import com.intellij.codeInsight.documentation.PlatformDocumentationUtil;
import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.OrderEntry;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.ResourceUtil;
import com.intellij.util.net.HttpConfigurable;

abstract class ErlangSdkDocProviderBase implements ElementDocProvider {
  private static final Pattern PATTERN_HREF = Pattern.compile("<a href=\"(.*?)\">");
  private static final Pattern PATTERN_EVALUATED_LINK = Pattern.compile("javascript:erlhref\\('.*?','.*?','(.*?)'\\);");
  private static final Pattern PATTERN_EXTERNAL_LINK = Pattern.compile("(.*)\\.html#(.*)");

  static final String HTTP_STYLE;
  static {
    final String css;
    try {
       css = ResourceUtil.loadText(ResourceUtil.getResource(
         ErlangSdkDocProviderBase.class, "/documentation", "erlang-sdk-doc.css"));
    } catch (IOException e) {
      throw (AssertionError) (new AssertionError().initCause(e));
    }
    HTTP_STYLE = "<style type=\"text/css\">\n" + css + "</style>\n";
  }

  @Nonnull
  private final Project myProject;
  @Nonnull
  private final VirtualFile myVirtualFile;
  @Nullable private List<OrderEntry> myOrderEntries;
  @Nullable private List<String> myExternalDocUrls;

  protected ErlangSdkDocProviderBase(@Nonnull Project project, @Nonnull VirtualFile virtualFile) {
    myProject = project;
    myVirtualFile = virtualFile;
  }

  @Nonnull
  @Override
  public List<String> getExternalDocUrls() {
    if (myExternalDocUrls == null) {
      myExternalDocUrls = getHttpUrls(getOrderEntries(), myVirtualFile, getInDocRef());
    }
    return myExternalDocUrls;
  }

  @Nullable
  @Override
  public String getDocText() {
    final List<String> fileUrls = getFileUrls(getOrderEntries(), myVirtualFile);
    final List<String> httpUrls = getExternalDocUrls();
    final List<String> urls = new ArrayList<String>(fileUrls.size() + httpUrls.size());
    urls.addAll(fileUrls);
    urls.addAll(httpUrls);
    for (String urlString : urls) {
      final BufferedReader reader = createReader(urlString);
      if (reader == null) {
        continue;
      }
      try {
        final String retrievedHtml = retrieveDoc(reader);
        if (retrievedHtml != null) {
          return decorateRetrievedHtml(retrievedHtml);
        }
      } finally {
        try {
          reader.close();
        } catch (IOException e) { // Ignore
        }
      }
    }
    return null;
  }

  @Nonnull
  private List<OrderEntry> getOrderEntries() {
    if (myOrderEntries == null) {
      final ProjectFileIndex fileIndex = ProjectRootManager.getInstance(myProject).getFileIndex();
      myOrderEntries = fileIndex.getOrderEntriesForFile(myVirtualFile);
    }
    return myOrderEntries;
  }

  @Nullable
  private String retrieveDoc(@Nonnull BufferedReader reader) {
    try {
      String line;
      boolean functionDocFound = false;
      while ((line = reader.readLine()) != null) {
        if (isDocBegin(line)) {
          functionDocFound = true;
          break;
        }
      }
      if (!functionDocFound) {
        return null;
      }
      final StringBuilder builder = new StringBuilder(1024);
      appendCorrectedLine(builder, line);
      while ((line = reader.readLine()) != null && !isDocEnd(line)) {
        appendCorrectedLine(builder, line);
        builder.append("\n");
      }
      return builder.toString();
    } catch (IOException e) { // Ignore
    } finally {
      try {
        reader.close();
      } catch (IOException e) { // Ignore
      }
    }
    return null;
  }

  @Nonnull
  private String appendCorrectedLine(@Nonnull StringBuilder builder, @Nonnull String line) {
    final Matcher matcher = PATTERN_HREF.matcher(line);
    int lastCopiedChar = 0;
    while (matcher.find()) {
      final MatchResult matchResult = matcher.toMatchResult();
      builder.append(line.substring(lastCopiedChar, matchResult.start()));
      final String linkHref = matchResult.group(1);
      final String convertedLink = convertLink(linkHref);
      builder.append("<a href=\"")
        .append(convertedLink)
        .append("\">");
      lastCopiedChar = matchResult.end();
    }
    builder.append(line.substring(lastCopiedChar, line.length()));
    return line;
  }

  @Nonnull
  protected abstract String getInDocRef();

  protected abstract boolean isDocEnd(@Nonnull String line);

  protected abstract boolean isDocBegin(@Nonnull String line);

  @Nonnull
  private static List<String> getHttpUrls(@Nonnull List<OrderEntry> orderEntries,
                                          @Nonnull VirtualFile virtualFile,
                                          @Nonnull String inDocRef) {
    for (OrderEntry orderEntry : orderEntries) {
      final String[] docRootUrls = orderEntry.getUrls(OrderRootType.DOCUMENTATION);
      final String sdkHttpDocRelPath = httpDocRelPath(virtualFile);
      final List<String> httpUrls = PlatformDocumentationUtil.getHttpRoots(
        docRootUrls, sdkHttpDocRelPath + inDocRef);
      if (httpUrls != null) {
        return httpUrls;
      }
    }
    return Collections.emptyList();
  }

  @Nonnull
  private static List<String> getFileUrls(@Nonnull List<OrderEntry> orderEntries,
                                          @Nonnull VirtualFile virtualFile) {
    List<String> fileUrls = null;
    for (OrderEntry orderEntry : orderEntries) {
      final VirtualFile[] docRootFiles = orderEntry.getFiles(OrderRootType.DOCUMENTATION);
      final String sdkHttpDocRelPath = httpDocRelPath(virtualFile);
      for (VirtualFile docRootFile : docRootFiles) {
        if (docRootFile.isInLocalFileSystem()) {
          if (fileUrls == null) {
            fileUrls = new ArrayList<String>();
          }
          fileUrls.add(docRootFile.getUrl() + "/" + sdkHttpDocRelPath);
        }
      }
    }
    return fileUrls != null ? fileUrls : Collections.<String>emptyList();
  }

  @Nullable
  private static BufferedReader createReader(@Nonnull String urlString) {
    try {
      final URL url = BrowserUtil.getURL(urlString);
      if (url == null) {
        return null;
      }
      if (url.getProtocol().equals("http")) {
        return createHttpReader(url);
      }
      else if (url.getProtocol().equals("file")) {
        return createFileReader(url);
      }
    } catch (Exception e) { // Ignore
    }
    return null;
  }

  @Nullable
  private static String httpDocRelPath(@Nonnull VirtualFile virtualFile) {
    final String appDirName = virtualFile.getParent().getParent().getName();
    final String prefix;
    if (appDirName.startsWith("erts")) {
      prefix = "";
    }
    else {
      prefix = "lib/";
    }
    return prefix + appDirName + "/doc/html/" + virtualFile.getNameWithoutExtension() + ".html";
  }

  @Nonnull
  private static BufferedReader createHttpReader(@Nonnull URL url) throws IOException {
    final HttpConfigurable httpConfigurable = HttpConfigurable.getInstance();
    httpConfigurable.prepareURL(url.toString());
    final URLConnection urlConnection = url.openConnection();
    final String contentEncoding = urlConnection.getContentEncoding();
    final InputStream inputStream = urlConnection.getInputStream();
    //noinspection IOResourceOpenedButNotSafelyClosed
    final InputStreamReader inputStreamReader = contentEncoding != null
      ? new InputStreamReader(inputStream, contentEncoding)
      : new InputStreamReader(inputStream);
    return new BufferedReader(inputStreamReader);
  }

  @Nullable
  private static BufferedReader createFileReader(@Nonnull URL url) {
    try {
      final InputStreamReader stream = new InputStreamReader(url.openStream());
      return new BufferedReader(stream);
    } catch (IOException e) {
      return null;
    }
  }

  @Nonnull
  private static String decorateRetrievedHtml(@Nonnull String retrievedHtml) {
    return "<html>\n" + HTTP_STYLE + "<body>\n" + retrievedHtml + "</body></html>\n";
  }

  @Nonnull
  private String convertLink(@Nonnull String href) {
    final Matcher evaluatedLinkMatcher = PATTERN_EVALUATED_LINK.matcher(href);
    final String concreteHref = (evaluatedLinkMatcher.matches()) ? evaluatedLinkMatcher.group(1) : href;
    final Matcher externalLinkMatcher = PATTERN_EXTERNAL_LINK.matcher(concreteHref);
    if (externalLinkMatcher.matches()) {
      return DocumentationManagerProtocol.PSI_ELEMENT_PROTOCOL + externalLinkMatcher.group(1) + "#" + externalLinkMatcher.group(2);
    }
    if (concreteHref.charAt(0) == '#') {
      return DocumentationManagerProtocol.PSI_ELEMENT_PROTOCOL + myVirtualFile.getNameWithoutExtension() + concreteHref;
    }
    if (concreteHref.endsWith(".html")) {
      return DocumentationManagerProtocol.PSI_ELEMENT_PROTOCOL + concreteHref.substring(0, concreteHref.length() - 5);
    }
    return href;
  }
}
