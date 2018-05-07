package org.intellij.erlang.debugger.node.commands;

import com.ericsson.otp.erlang.*;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.util.ArrayUtil;
import com.intellij.util.Function;
import com.intellij.util.containers.ContainerUtil;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.List;

public final class ErlangDebuggerCommandsProducer {
  private ErlangDebuggerCommandsProducer() {
  }

  @Nonnull
  public static ErlangDebuggerCommand getSetBreakpointCommand(@Nonnull String module, int line) {
    return new SetBreakpointCommand(module, line);
  }

  @Nonnull
  public static ErlangDebuggerCommand getRemoveBreakpointCommand(@Nonnull String module, int line) {
    return new RemoveBreakpointCommand(module, line);
  }

  @Nonnull
  public static ErlangDebuggerCommand getRunDebuggerCommand(@Nonnull String module, @Nonnull String function, @Nonnull List<String> args) {
    return new RunDebuggerCommand(module, function, args);
  }

  @Nonnull
  public static ErlangDebuggerCommand getInterpretModulesCommand(@Nonnull List<String> moduleNames) {
    return new InterpretModulesCommand(moduleNames);
  }

  @Nonnull
  public static ErlangDebuggerCommand getDebugRemoteNodeCommand(@Nonnull String nodeName, @Nullable String cookie) {
    return new DebugRemoteNodeCommand(nodeName, cookie);
  }

  @Nonnull
  public static ErlangDebuggerCommand getStepIntoCommand(@Nonnull OtpErlangPid pid) {
    return new StepIntoCommand(pid);
  }

  @Nonnull
  public static ErlangDebuggerCommand getStepOverCommand(@Nonnull OtpErlangPid pid) {
    return new StepOverCommand(pid);
  }

  @Nonnull
  public static ErlangDebuggerCommand getStepOutCommand(@Nonnull OtpErlangPid pid) {
    return new StepOutCommand(pid);
  }

  @Nonnull
  public static ErlangDebuggerCommand getContinueCommand(@Nonnull OtpErlangPid pid) {
    return new ContinueCommand(pid);
  }

  private static class StepOverCommand extends AbstractPidCommand {
    public StepOverCommand(@Nonnull OtpErlangPid pid) {
      super("step_over", pid);
    }
  }

  private static class RunDebuggerCommand implements ErlangDebuggerCommand {
    private final String myModule;
    private final String myFunction;
    private final List<String> myArgs;

    RunDebuggerCommand(@Nonnull String module, @Nonnull String function, @Nonnull List<String> args) {
      myModule = module;
      myFunction = function;
      myArgs = args;
    }

    @Nonnull
    @Override
    public OtpErlangTuple toMessage() {
      return new OtpErlangTuple(new OtpErlangObject[] {
        new OtpErlangAtom("run_debugger"),
        new OtpErlangAtom(myModule),
        new OtpErlangAtom(myFunction),
        new OtpErlangString("[" + StringUtil.join(myArgs, ",") + "]")
      });
    }
  }

  private static class SetBreakpointCommand implements ErlangDebuggerCommand {
    private final String myModule;
    private final int myLine;

    SetBreakpointCommand(@Nonnull String module, int line) {
      myModule = module;
      myLine = line + 1;
    }

    @Nonnull
    @Override
    public OtpErlangTuple toMessage() {
      return new OtpErlangTuple(new OtpErlangObject[]{
        new OtpErlangAtom("set_breakpoint"),
        new OtpErlangAtom(myModule),
        new OtpErlangInt(myLine)
      });
    }
  }

  private static abstract class AbstractPidCommand implements ErlangDebuggerCommand {
    private final String myName;
    private final OtpErlangPid myPid;

    protected AbstractPidCommand(@Nonnull String cmdName, @Nonnull OtpErlangPid pid) {
      myName = cmdName;
      myPid = pid;
    }

    @Nonnull
    @Override
    public OtpErlangTuple toMessage() {
      return new OtpErlangTuple(new OtpErlangObject[]{new OtpErlangAtom(myName), myPid});
    }
  }

  private static class StepOutCommand extends AbstractPidCommand {
    public StepOutCommand(@Nonnull OtpErlangPid pid) {
      super("step_out", pid);
    }
  }

  private static class StepIntoCommand extends AbstractPidCommand {
    public StepIntoCommand(@Nonnull OtpErlangPid pid) {
      super("step_into", pid);
    }
  }

  private static class ContinueCommand extends AbstractPidCommand {
    protected ContinueCommand(@Nonnull OtpErlangPid pid) {
      super("continue", pid);
    }
  }

  private static class InterpretModulesCommand implements ErlangDebuggerCommand {
    private final List<String> myModuleNames;

    public InterpretModulesCommand(@Nonnull List<String> moduleNames) {
      myModuleNames = moduleNames;
    }

    @Nonnull
    @Override
    public OtpErlangTuple toMessage() {
      List<OtpErlangObject> moduleNameAtoms = ContainerUtil.map(myModuleNames, new Function<String, OtpErlangObject>() {
        @Nonnull
        @Override
        public OtpErlangObject fun(String moduleName) {
          return new OtpErlangAtom(moduleName);
        }
      });
      return new OtpErlangTuple(new OtpErlangObject[] {
        new OtpErlangAtom("interpret_modules"),
        new OtpErlangList(ArrayUtil.toObjectArray(moduleNameAtoms, OtpErlangObject.class))
      });
    }
  }

  private static class DebugRemoteNodeCommand implements ErlangDebuggerCommand {
    private final String myNodeName;
    private final String myCookie;

    public DebugRemoteNodeCommand(@Nonnull String nodeName, @Nullable String cookie) {
      myNodeName = nodeName;
      myCookie = !StringUtil.isEmptyOrSpaces(cookie) ? cookie : "nocookie";
    }

    @Nonnull
    @Override
    public OtpErlangTuple toMessage() {
      return new OtpErlangTuple(new OtpErlangObject[] {
        new OtpErlangAtom("debug_remote_node"),
        new OtpErlangAtom(myNodeName),
        new OtpErlangAtom(myCookie)
      });
    }
  }

  private static class RemoveBreakpointCommand implements ErlangDebuggerCommand {
    private final String myModule;
    private final int myLine;

    public RemoveBreakpointCommand(@Nonnull String module, int line) {
      myModule = module;
      myLine = line + 1;
    }

    @Nonnull
    @Override
    public OtpErlangTuple toMessage() {
      return new OtpErlangTuple(new OtpErlangObject[] {
        new OtpErlangAtom("remove_breakpoint"),
        new OtpErlangAtom(myModule),
        new OtpErlangInt(myLine)
      });
    }
  }

  public interface ErlangDebuggerCommand {
    @Nonnull
    OtpErlangTuple toMessage();
  }
}
