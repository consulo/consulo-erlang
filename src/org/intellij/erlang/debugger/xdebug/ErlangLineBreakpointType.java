/*
 * Copyright 2012-2014 Sergey Ignatov
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

package org.intellij.erlang.debugger.xdebug;

import org.consulo.lombok.annotations.LazyInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.xdebugger.breakpoints.XLineBreakpointType;

public class ErlangLineBreakpointType extends XLineBreakpointType<ErlangLineBreakpointProperties>
{
	@NotNull
	@LazyInstance
	public static ErlangLineBreakpointType getInstance()
	{
		return EXTENSION_POINT_NAME.findExtension(ErlangLineBreakpointType.class);
	}

	public ErlangLineBreakpointType()
	{
		super("erlang-breakpoint-type", "Erlang Breakpoint Types");
	}

	@Nullable
	@Override
	public ErlangLineBreakpointProperties createBreakpointProperties(@NotNull VirtualFile file, int line)
	{
		return new ErlangLineBreakpointProperties();
	}
}