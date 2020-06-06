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

package org.intellij.erlang.typing;

import org.intellij.erlang.utils.ErlangLightPlatformCodeInsightFixtureTestCase;

public abstract class ErlangTypedHandlerTest extends ErlangLightPlatformCodeInsightFixtureTestCase {
  public void testNotPaired() throws Throwable { doTest('(', "foo() -> <caret>a", "foo() -> (<caret>a"); }
  public void testPaired()    throws Throwable { doTest('(', "foo<caret>", "foo(<caret>)"); }

  private void doTest(char c, String before, String after) {
    myFixture.configureByText("a.erl", before);
    myFixture.type(c);
    myFixture.checkResult(after);
  }
}