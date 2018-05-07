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
import org.intellij.erlang.psi.ErlangTypeDefinition;
import org.intellij.erlang.psi.impl.ErlangTypeDefinitionImpl;
import org.intellij.erlang.stubs.ErlangTypeDefinitionStub;
import javax.annotation.Nonnull;

import java.io.IOException;

public class ErlangTypeDefinitionElementType extends ErlangNamedStubElementType<ErlangTypeDefinitionStub, ErlangTypeDefinition> {
  public static final ErlangTypeDefinition[] EMPTY_ARRAY = new ErlangTypeDefinition[0];

  public static final ArrayFactory<ErlangTypeDefinition> ARRAY_FACTORY = new ArrayFactory<ErlangTypeDefinition>() {
    @Nonnull
    @Override
    public ErlangTypeDefinition[] create(final int count) {
      return count == 0 ? EMPTY_ARRAY : new ErlangTypeDefinition[count];
    }
  };

  public ErlangTypeDefinitionElementType(String name) {
    super(name);
  }

  @Override
  public ErlangTypeDefinition createPsi(@Nonnull ErlangTypeDefinitionStub stub) {
    return new ErlangTypeDefinitionImpl(stub, this);
  }

  @Override
  public ErlangTypeDefinitionStub createStub(@Nonnull ErlangTypeDefinition psi, StubElement parentStub) {
    return new ErlangTypeDefinitionStub(parentStub, this, psi.getName(), psi.getArity());
  }

  @Override
  public void serialize(@Nonnull ErlangTypeDefinitionStub stub, @Nonnull StubOutputStream dataStream) throws IOException {
    dataStream.writeName(stub.getName());
    dataStream.writeInt(stub.getArity());
  }

  @Nonnull
  @Override
  public ErlangTypeDefinitionStub deserialize(@Nonnull StubInputStream dataStream, StubElement parentStub) throws IOException {
    return new ErlangTypeDefinitionStub(parentStub, this, dataStream.readName(), dataStream.readInt());
  }
}
