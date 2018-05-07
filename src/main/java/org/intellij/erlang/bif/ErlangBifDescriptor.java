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

package org.intellij.erlang.bif;

import javax.annotation.Nonnull;

public final class ErlangBifDescriptor implements Comparable<ErlangBifDescriptor> {
  @Nonnull
  private final String myModule;
  @Nonnull
  private final String myName;
  private final int myArity;
  @Nonnull
  private final String myParams;

  public ErlangBifDescriptor(@Nonnull String module, @Nonnull String name, int arity, @Nonnull String params) {
    myModule = module;
    myName = name;
    myArity = arity;
    myParams = params;
  }

  @Nonnull
  public String getModule() {
    return myModule;
  }

  @Nonnull
  public String getName() {
    return myName;
  }

  public int getArity() {
    return myArity;
  }

  @Nonnull
  public String getParams() {
    return myParams;
  }

  @Override
  public String toString() {
    return myModule + ":" + myName + "/" + myArity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ErlangBifDescriptor that = (ErlangBifDescriptor) o;

    if (myArity != that.myArity) return false;
    if (!myModule.equals(that.myModule)) return false;
    if (!myName.equals(that.myName)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = myModule.hashCode();
    result = 31 * result + myName.hashCode();
    result = 31 * result + myArity;
    return result;
  }

  @Override
  public int compareTo(@Nonnull ErlangBifDescriptor that) {
    int result = myModule.compareTo(that.myModule);
    if (result == 0) {
      result = myName.compareTo(that.myName);
      if (result == 0) {
        result = Integer.signum(myArity - that.myArity);
      }
    }
    return result;
  }
}
