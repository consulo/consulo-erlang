package org.intellij.erlang.debugger.xdebug;

import com.intellij.xdebugger.breakpoints.XBreakpointProperties;
import javax.annotation.Nullable;

public class ErlangLineBreakpointProperties extends XBreakpointProperties<ErlangLineBreakpointProperties> {
  @Nullable
  @Override
  public ErlangLineBreakpointProperties getState() {
    return this;
  }

  @Override
  public void loadState(ErlangLineBreakpointProperties state) {
  }
}
