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

package org.intellij.erlang.runconfig;

import org.intellij.erlang.application.ErlangApplicationConfiguration;
import org.intellij.erlang.eunit.ErlangUnitRunConfiguration;
import javax.annotation.Nonnull;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.ExecutionResult;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.RunProfile;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.executors.DefaultRunExecutor;
import com.intellij.execution.runners.DefaultProgramRunner;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.runners.ProgramRunner;
import com.intellij.execution.runners.RunContentBuilder;
import com.intellij.execution.ui.RunContentDescriptor;
import com.intellij.openapi.fileEditor.FileDocumentManager;

public class ErlangRunner extends DefaultProgramRunner
{
	public static final String ERLANG_RUNNER_ID = "ErlangRunner";

	public static final RunProfileState EMPTY_RUN_STATE = new RunProfileState()
	{
		@Override
		public ExecutionResult execute(final Executor executor, @Nonnull final ProgramRunner runner) throws ExecutionException
		{
			return null;
		}
	};

	@Nonnull
	@Override
	public String getRunnerId()
	{
		return ERLANG_RUNNER_ID;
	}

	@Override
	public boolean canRun(@Nonnull String executorId, @Nonnull RunProfile profile)
	{
		return DefaultRunExecutor.EXECUTOR_ID.equals(executorId) && (profile instanceof ErlangApplicationConfiguration || profile instanceof ErlangUnitRunConfiguration);
	}

	@Override
	protected RunContentDescriptor doExecute(RunProfileState state, ExecutionEnvironment env) throws ExecutionException
	{
		final ErlangRunConfigurationBase configuration = (ErlangRunConfigurationBase) env.getRunProfile();
		final ErlangRunningState runningState = configuration.createRunningState(env);
		FileDocumentManager.getInstance().saveAllDocuments();
		ExecutionResult executionResult = runningState.execute(env.getExecutor(), this);
		return new RunContentBuilder(executionResult, env).showRunContent(env.getContentToReuse());
	}
}