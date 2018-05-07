package org.intellij.erlang.debugger.xdebug;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.intellij.erlang.application.ErlangApplicationConfiguration;
import org.intellij.erlang.debugger.remote.ErlangRemoteDebugRunConfiguration;
import org.intellij.erlang.eunit.ErlangUnitRunConfiguration;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.RunProfile;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.executors.DefaultDebugExecutor;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.runners.GenericProgramRunner;
import com.intellij.execution.ui.RunContentDescriptor;
import com.intellij.xdebugger.XDebugProcess;
import com.intellij.xdebugger.XDebugProcessStarter;
import com.intellij.xdebugger.XDebugSession;
import com.intellij.xdebugger.XDebuggerManager;

public class ErlangDebugRunner extends GenericProgramRunner
{
	public static final String ERLANG_DEBUG_RUNNER_ID = "ErlangDebugRunner";

	@Nullable
	@Override
	protected RunContentDescriptor doExecute(@Nonnull RunProfileState state, @Nonnull final ExecutionEnvironment env) throws ExecutionException
	{
		XDebuggerManager xDebuggerManager = XDebuggerManager.getInstance(env.getProject());
		return xDebuggerManager.startSession(env, new XDebugProcessStarter()
		{
			@Nonnull
			@Override
			public XDebugProcess start(@Nonnull XDebugSession session) throws ExecutionException
			{
				return new ErlangXDebugProcess(session, env);
			}
		}).getRunContentDescriptor();
	}

	@Nonnull
	@Override
	public String getRunnerId()
	{
		return ERLANG_DEBUG_RUNNER_ID;
	}

	@Override
	public boolean canRun(@Nonnull String executorId, @Nonnull RunProfile profile)
	{
		return DefaultDebugExecutor.EXECUTOR_ID.equals(executorId) && (profile instanceof ErlangApplicationConfiguration ||
				profile instanceof ErlangUnitRunConfiguration ||
				profile instanceof ErlangRemoteDebugRunConfiguration);
	}
}