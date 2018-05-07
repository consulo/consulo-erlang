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

package org.intellij.erlang.debugger.node;

import com.ericsson.otp.erlang.OtpErlangPid;
import org.intellij.erlang.debugger.xdebug.ErlangSourcePosition;
import org.intellij.erlang.psi.ErlangFile;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.List;

public class ErlangProcessSnapshot {
  private final OtpErlangPid myPid;
  private final ErlangTraceElement myInit;
  private final String myStatus;
  private final ErlangSourcePosition myBreakPosition;
  private final String myExitReason;
  private final List<ErlangTraceElement> myStack;

  public ErlangProcessSnapshot(@Nonnull OtpErlangPid pid,
                               @Nonnull ErlangTraceElement init,
                               @Nonnull String status,
                               @Nullable ErlangFile breakModule,
                               int breakLine, 
                               @Nullable String exitReason,
                               @Nonnull List<ErlangTraceElement> stack) {
    myPid = pid;
    myInit = init;
    myStatus = status;
    myBreakPosition = breakModule != null ? new ErlangSourcePosition(breakModule, breakLine) : null;
    myExitReason = exitReason;
    myStack = stack;
  }

  @Nonnull
  public OtpErlangPid getPid() {
    return myPid;
  }

  @Nonnull
  public String getPidString() {
    return myPid.toString();
  }

  @Nonnull
  public ErlangTraceElement getInit() {
    return myInit;
  }

  @Nonnull
  public String getStatus() {
    return myStatus;
  }

  @Nullable
  public ErlangSourcePosition getBreakPosition() {
    return myBreakPosition;
  }

  @Nullable
  public String getExitReason() {
    return myExitReason;
  }

  @Nonnull
  public List<ErlangTraceElement> getStack() {
    return myStack;
  }
}
