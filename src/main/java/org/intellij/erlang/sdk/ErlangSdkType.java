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

package org.intellij.erlang.sdk;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;

import org.intellij.erlang.ErlangIcons;
import org.jetbrains.annotations.NonNls;

import javax.annotation.Nullable;
import org.jetbrains.annotations.TestOnly;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.process.ProcessOutput;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.projectRoots.SdkModificator;
import com.intellij.openapi.projectRoots.SdkType;
import com.intellij.openapi.projectRoots.impl.SdkImpl;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.util.Ref;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.util.Processor;
import com.intellij.util.containers.ContainerUtil;
import consulo.roots.types.BinariesOrderRootType;
import consulo.roots.types.DocumentationOrderRootType;
import consulo.roots.types.SourcesOrderRootType;
import consulo.ui.image.Image;

public class ErlangSdkType extends SdkType
{
	@Nonnull
	public static ErlangSdkType getInstance()
	{
		return EP_NAME.findExtension(ErlangSdkType.class);
	}

	public ErlangSdkType()
	{
		super("ERLANG_SDK");
	}

	@Nonnull
	@Override
	public Image getIcon()
	{
		return ErlangIcons.ERLANG;
	}

	@Nonnull
	@Override
	public Collection<String> suggestHomePaths()
	{
		String s = suggestHomePath();
		if(s != null)
		{
			return Collections.singletonList(s);
		}
		return super.suggestHomePaths();
	}

	@Override
	public boolean canCreatePredefinedSdks()
	{
		return true;
	}

	@Nullable
	private String suggestHomePath()
	{
		if(SystemInfo.isWindows)
		{
			return "C:\\cygwin\\bin";
		}
		else if(SystemInfo.isMac)
		{
			String macPorts = "/opt/local/lib/erlang";
			if(new File(macPorts).exists())
			{
				return macPorts;
			}

			// For home brew we trying to find something like /usr/local/Cellar/erlang/*/lib/erlang as SDK root
			for(String version : new String[]{
					"",
					"-r14",
					"-r15",
					"-r16"
			})
			{
				File brewRoot = new File("/usr/local/Cellar/erlang" + version);
				if(brewRoot.exists())
				{
					final Ref<String> ref = Ref.create();
					FileUtil.processFilesRecursively(brewRoot, new Processor<File>()
					{
						@Override
						public boolean process(File file)
						{
							if(!ref.isNull())
							{
								return false;
							}
							if(!file.isDirectory())
							{
								return true;
							}
							if("erlang".equals(file.getName()) && file.getParent().endsWith("lib"))
							{
								ref.set(file.getAbsolutePath());
								return false;
							}
							return true;
						}
					});
					if(!ref.isNull())
					{
						return ref.get();
					}
				}
			}
			return null;
		}
		else if(SystemInfo.isLinux)
		{
			return "/usr/lib/erlang";
		}
		return null;
	}

	@Override
	public boolean isValidSdkHome(@Nonnull final String path)
	{
		final File erl = getTopLevelExecutable(path);
		final File erlc = getByteCodeCompilerExecutable(path);
		return erl.canExecute() && erlc.canExecute();
	}

	@Nonnull
	public static File getTopLevelExecutable(@Nonnull final String sdkHome)
	{
		return getExecutable(new File(sdkHome, "bin").getAbsolutePath(), "erl");
	}

	@Nonnull
	public static File getExecutable(@Nonnull final String path, @Nonnull final String command)
	{
		return new File(path, SystemInfo.isWindows ? command + ".exe" : command);
	}

	@Nonnull
	public static File getByteCodeCompilerExecutable(@Nonnull final String sdkHome)
	{
		return getExecutable(new File(sdkHome, "bin").getAbsolutePath(), "erlc");
	}

	@Nonnull
	@Override
	public String suggestSdkName(@Nullable final String currentSdkName, @Nonnull final String sdkHome)
	{
		String version = getVersionString(sdkHome);
		if(version == null)
		{
			return "Unknown Erlang version at " + sdkHome;
		}
		return "Erlang " + version;
	}

	@Nullable
	@Override
	public String getVersionString(@Nonnull final String sdkHome)
	{
		return getReleaseString(sdkHome);
	}

	@Nullable
	@Override
	public String getDefaultDocumentationUrl(@Nonnull Sdk sdk)
	{
		return getDefaultDocumentationUrl(getRelease(sdk));
	}

	@Nonnull
	@NonNls
	@Override
	public String getPresentableName()
	{
		return "Erlang SDK";
	}

	@Override
	public void setupSdkPaths(@Nonnull final Sdk sdk)
	{
		configureSdkPaths(sdk);
	}

	@Override
	public boolean isRootTypeApplicable(OrderRootType type)
	{
		return type == BinariesOrderRootType.getInstance() || type == DocumentationOrderRootType.getInstance() || type == SourcesOrderRootType
				.getInstance();
	}

	@TestOnly
	@Nonnull
	public static Sdk createMockSdk(@Nonnull final String sdkHome)
	{
		final String release = getReleaseString(sdkHome);
		final Sdk sdk = new SdkImpl(release, getInstance());
		final SdkModificator sdkModificator = sdk.getSdkModificator();
		sdkModificator.setHomePath(sdkHome);
		sdkModificator.setVersionString(release); // must be set after home path, otherwise setting home path clears the version string
		sdkModificator.commitChanges();
		configureSdkPaths(sdk);
		return sdk;
	}

	private static void configureSdkPaths(@Nonnull final Sdk sdk)
	{
		final SdkModificator sdkModificator = sdk.getSdkModificator();
		setupLocalSdkPaths(sdkModificator);

		final String externalDocUrl = getDefaultDocumentationUrl(getRelease(sdk));
		if(externalDocUrl != null)
		{
			final VirtualFile fileByUrl = VirtualFileManager.getInstance().findFileByUrl(externalDocUrl);
			sdkModificator.addRoot(fileByUrl, DocumentationOrderRootType.getInstance());
		}
		sdkModificator.commitChanges();
	}

	@Nullable
	public static ErlangSdkRelease getRelease(@Nonnull final Sdk sdk)
	{
		String versionString = sdk.getVersionString();
		try
		{
			return versionString == null ? null : ErlangSdkRelease.valueOf(versionString);
		}
		catch(IllegalArgumentException e)
		{
			return null;
		}
	}

	@Nullable
	private static String getReleaseString(@Nonnull final String sdkHome)
	{
		Pattern pattern = Pattern.compile("R\\d+.*");
		// determine the version from the 'releases' directory, if it exists
		File releases = new File(sdkHome, "releases");
		if(releases.isDirectory())
		{
			File firstItem = ContainerUtil.getFirstItem(FileUtil.findFilesOrDirsByMask(pattern, releases));
			if(firstItem == null)
			{
				return null;
			}
			return firstItem.getName();
		}
		else
		{
			// releases dir did not exist, so let's see if we can parse the version by walking up the parents
			File current = releases.getParentFile();
			while(current != null)
			{
				if(pattern.matcher(current.getName()).matches())
				{
					return current.getName();
				}
				current = current.getParentFile();
			}
		}
		return null;
	}

	@Nullable
	private static String getDefaultDocumentationUrl(@Nullable final ErlangSdkRelease release)
	{
		return release == null ? null : "http://www.erlang.org/documentation/doc-" + release.getVersion();
	}

	private static void setupLocalSdkPaths(@Nonnull final SdkModificator sdkModificator)
	{
		final String sdkHome = sdkModificator.getHomePath();

		{
			final File stdLibDir = new File(new File(sdkHome), "lib");
			if(tryToProcessAsStandardLibraryDir(sdkModificator, stdLibDir))
			{
				return;
			}
		}

		try
		{
			final String exePath = getByteCodeCompilerExecutable(sdkHome).getAbsolutePath();
			final ProcessOutput processOutput = ErlangSystemUtil.getProcessOutput(sdkHome, exePath, "-where");
			if(processOutput.getExitCode() == 0)
			{
				final String stdout = processOutput.getStdout().trim();
				if(!stdout.isEmpty())
				{
					if(SystemInfo.isWindows && stdout.startsWith("/"))
					{
						for(final File root : File.listRoots())
						{
							final File stdLibDir = new File(root, stdout);
							if(tryToProcessAsStandardLibraryDir(sdkModificator, stdLibDir))
							{
								return;
							}
						}
					}
					else
					{
						final File stdLibDir = new File(stdout);
						if(tryToProcessAsStandardLibraryDir(sdkModificator, stdLibDir))
						{
							return;
						}
					}
				}
			}
		}
		catch(final ExecutionException ignore)
		{
		}

		final File stdLibDir = new File("/usr/lib/erlang");
		tryToProcessAsStandardLibraryDir(sdkModificator, stdLibDir);
	}

	private static boolean tryToProcessAsStandardLibraryDir(@Nonnull final SdkModificator sdkModificator, @Nonnull final File stdLibDir)
	{
		if(!isStandardLibraryDir(stdLibDir))
		{
			return false;
		}
		final VirtualFile dir = LocalFileSystem.getInstance().findFileByIoFile(stdLibDir);
		if(dir != null)
		{
			sdkModificator.addRoot(dir, BinariesOrderRootType.getInstance());
			sdkModificator.addRoot(dir, SourcesOrderRootType.getInstance());
		}
		return true;
	}

	private static boolean isStandardLibraryDir(@Nonnull final File dir)
	{
		return dir.isDirectory();
	}
}
