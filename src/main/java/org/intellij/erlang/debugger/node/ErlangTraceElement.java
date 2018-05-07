package org.intellij.erlang.debugger.node;

import com.ericsson.otp.erlang.OtpErlangList;
import org.intellij.erlang.psi.ErlangFile;
import javax.annotation.Nonnull;

import java.util.Collection;

public class ErlangTraceElement {
  private final ErlangFile myModule;
  private final String myFunction;
  private final OtpErlangList myFunctionArgs;
  private final Collection<ErlangVariableBinding> myBindings;

  public ErlangTraceElement(@Nonnull ErlangFile module,
                            @Nonnull String function,
                            @Nonnull OtpErlangList functionArgs,
                            @Nonnull Collection<ErlangVariableBinding> bindings) {
    myModule = module;
    myFunction = function;
    myFunctionArgs = functionArgs;
    myBindings = bindings;
  }

  @Nonnull
  public ErlangFile getModule() {
    return myModule;
  }

  @Nonnull
  public String getFunction() {
    return myFunction;
  }

  @Nonnull
  public OtpErlangList getFunctionArgs() {
    return myFunctionArgs;
  }

  @Nonnull
  public Collection<ErlangVariableBinding> getBindings() {
    return myBindings;
  }
}