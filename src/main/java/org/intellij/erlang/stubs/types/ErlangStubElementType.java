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

import javax.annotation.Nonnull;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.IndexSink;
import com.intellij.psi.stubs.StubElement;
import org.intellij.erlang.ErlangLanguage;
import org.intellij.erlang.psi.ErlangCompositeElement;
import org.jetbrains.annotations.NonNls;

public abstract class ErlangStubElementType<S extends StubElement<T>, T extends ErlangCompositeElement> extends IStubElementType<S, T> {
  public ErlangStubElementType(@NonNls @Nonnull String debugName) {
    super(debugName, ErlangLanguage.INSTANCE);
  }

  public void indexStub(@Nonnull final S stub, @Nonnull final IndexSink sink) {
  }

  @Nonnull
  public String getExternalId() {
    return "erlang." + super.toString();
  }
}
