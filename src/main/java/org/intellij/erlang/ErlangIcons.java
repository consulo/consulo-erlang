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
import consulo.erlang.icon.ErlangIconGroup;
import consulo.ui.image.Image;
import consulo.ui.image.ImageEffects;

public interface ErlangIcons
{
	Image FUNCTION = AllIcons.Nodes.Function;
	Image ATTRIBUTE = AllIcons.Nodes.Attribute;
	Image FUNCTION_CLAUSE = AllIcons.Nodes.AnonymousClass;
	Image RECORD = ErlangIconGroup.braces();
	Image MACROS = ErlangIconGroup.macro();
	Image MODULE = AllIcons.Nodes.Package;
	Image VARIABLE = AllIcons.Nodes.Variable;
	Image FIELD = AllIcons.Nodes.Field;
	Image TYPE = ErlangIconGroup.type();
	Image CALLBACK = AllIcons.Nodes.Interface;
	Image ERLANG_MARK = ErlangIconGroup.erlang_mark();
	Image ERLANG_BIG = ErlangIconGroup.erlang_big();
	Image RECURSIVE_CALL = AllIcons.Gutter.RecursiveMethod;

	Image FILE = ErlangIconGroup.erlang_module_16();
	Image OTP_SUPERVISOR = ErlangIconGroup.otp_supervisor_16();
	Image OTP_APPLICATION = ErlangIconGroup.otp_application_16();
	Image TERMS = ErlangIconGroup.erlang_terms_16();
	Image OTP_GEN_EVENT = ErlangIconGroup.otp_gen_event_16();
	Image OTP_GEN_SERVER = ErlangIconGroup.otp_gen_server_16();
	Image OTP_GEN_FSM = ErlangIconGroup.otp_gen_fsm_16();
	Image OTP_APP_RESOURCE = ErlangIconGroup.otp_app_16();
	Image EUNIT = ImageEffects.layered(FILE, AllIcons.Nodes.JunitTestMark);
	Image HEADER = ErlangIconGroup.erlang_header_16();

	Image ERLANG = ErlangIconGroup.erlang_small_16();
	Image REBAR = ErlangIconGroup.rebar_16();
	Image REBAR_MODULE_CONFLICT = ErlangIconGroup.rebar_module_conflict_16();
	Image REBAR_EUNIT = ImageEffects.layered(REBAR, AllIcons.Nodes.JunitTestMark);
	Image ERLANG_CONSOLE = ErlangIconGroup.erlang_console();

	Image IncludeRoot = ErlangIconGroup.includeRoot();
}
