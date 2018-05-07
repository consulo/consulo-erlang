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

package org.intellij.erlang.stubs.types;

import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import com.intellij.util.ArrayFactory;
import org.intellij.erlang.psi.ErlangMacrosDefinition;
import org.intellij.erlang.psi.impl.ErlangMacrosDefinitionImpl;
import org.intellij.erlang.stubs.ErlangMacrosDefinitionStub;
import javax.annotation.Nonnull;

import java.io.IOException;

public class ErlangMacrosDefinitionElementType extends ErlangNamedStubElementType<ErlangMacrosDefinitionStub, ErlangMacrosDefinition> {
  public static final ErlangMacrosDefinition[] EMPTY_ARRAY = new ErlangMacrosDefinition[0];

  public static final ArrayFactory<ErlangMacrosDefinition> ARRAY_FACTORY = new ArrayFactory<ErlangMacrosDefinition>() {
    @Nonnull
    @Override
    public ErlangMacrosDefinition[] create(final int count) {
      return count == 0 ? EMPTY_ARRAY : new ErlangMacrosDefinition[count];
    }
  };

  public ErlangMacrosDefinitionElementType(String name) {
    super(name);
  }

  @Override
  public ErlangMacrosDefinition createPsi(@Nonnull ErlangMacrosDefinitionStub stub) {
    return new ErlangMacrosDefinitionImpl(stub, this);
  }

  @Override
  public ErlangMacrosDefinitionStub createStub(@Nonnull ErlangMacrosDefinition psi, StubElement parentStub) {
    return new ErlangMacrosDefinitionStub(parentStub, this, psi.getName());
  }

  @Override
  public void serialize(@Nonnull ErlangMacrosDefinitionStub stub, @Nonnull StubOutputStream dataStream) throws IOException {
    dataStream.writeName(stub.getName());
  }

  @Nonnull
  @Override
  public ErlangMacrosDefinitionStub deserialize(@Nonnull StubInputStream dataStream, StubElement parentStub) throws IOException {
    return new ErlangMacrosDefinitionStub(parentStub, this, dataStream.readName());
  }
}
