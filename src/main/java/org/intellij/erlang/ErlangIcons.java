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

import com.intellij.icons.AllIcons;
import com.intellij.openapi.util.IconLoader;
import consulo.ui.image.Image;
import consulo.ui.image.ImageEffects;

public interface ErlangIcons
{
	Image FUNCTION = AllIcons.Nodes.Function;
	Image ATTRIBUTE = AllIcons.Nodes.Attribute;
	Image FUNCTION_CLAUSE = AllIcons.Nodes.AnonymousClass;
	Image RECORD = IconLoader.getIcon("/icons/braces.png");
	Image MACROS = IconLoader.getIcon("/icons/macro.png");
	Image MODULE = AllIcons.Nodes.Package;
	Image VARIABLE = AllIcons.Nodes.Variable;
	Image FIELD = AllIcons.Nodes.Field;
	Image TYPE = IconLoader.getIcon("/icons/type.png");
	Image CALLBACK = AllIcons.Nodes.Interface;
	Image ERLANG_MARK = IconLoader.getIcon("/icons/erlang-mark.png");
	Image ERLANG_BIG = IconLoader.getIcon("/icons/erlang-big.png");
	Image RECURSIVE_CALL = AllIcons.Gutter.RecursiveMethod;

	Image FILE = IconLoader.getIcon("/icons/erlang-module-16.png");
	Image OTP_SUPERVISOR = IconLoader.getIcon("/icons/otp-supervisor-16.png");
	Image OTP_APPLICATION = IconLoader.getIcon("/icons/otp-application-16.png");
	Image TERMS = IconLoader.getIcon("/icons/erlang-terms-16.png");
	Image OTP_GEN_EVENT = IconLoader.getIcon("/icons/otp-gen-event-16.png");
	Image OTP_GEN_SERVER = IconLoader.getIcon("/icons/otp-gen-server-16.png");
	Image OTP_GEN_FSM = IconLoader.getIcon("/icons/otp-gen-fsm-16.png");
	Image OTP_APP_RESOURCE = IconLoader.getIcon("/icons/otp-app-16.png");
	Image EUNIT = ImageEffects.layered(FILE, AllIcons.Nodes.JunitTestMark);
	Image HEADER = IconLoader.getIcon("/icons/erlang-header-16.png");

	Image ERLANG = IconLoader.getIcon("/icons/erlang-small-16.png");
	Image REBAR = IconLoader.getIcon("/icons/rebar-16.png");
	Image REBAR_MODULE_CONFLICT = IconLoader.getIcon("/icons/rebar-module-conflict-16.png");
	Image REBAR_EUNIT = ImageEffects.layered(REBAR, AllIcons.Nodes.JunitTestMark);
	Image ERLANG_CONSOLE = IconLoader.getIcon("/icons/erlang-console.png");

	Image IncludeRoot = IconLoader.getIcon("/icons/includeRoot.png");
}
