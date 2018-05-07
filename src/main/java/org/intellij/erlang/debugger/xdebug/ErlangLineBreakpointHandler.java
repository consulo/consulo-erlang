package org.intellij.erlang.debugger.xdebug;

import javax.annotation.Nonnull;

import com.intellij.xdebugger.breakpoints.XBreakpointHandler;
import com.intellij.xdebugger.breakpoints.XLineBreakpoint;

public class ErlangLineBreakpointHandler extends XBreakpointHandler<XLineBreakpoint<ErlangLineBreakpointProperties>> {
  private final ErlangXDebugProcess myDebugProcess;

  public ErlangLineBreakpointHandler(ErlangXDebugProcess debugProcess) {
    super(ErlangLineBreakpointType.class);
    myDebugProcess = debugProcess;
  }

  @Override
  public void registerBreakpoint(@Nonnull XLineBreakpoint<ErlangLineBreakpointProperties> breakpoint) {
    myDebugProcess.addBreakpoint(breakpoint);
  }

  @Override
  public void unregisterBreakpoint(@Nonnull XLineBreakpoint<ErlangLineBreakpointProperties> breakpoint, boolean temporary) {
    myDebugProcess.removeBreakpoint(breakpoint, temporary);
  }
}
