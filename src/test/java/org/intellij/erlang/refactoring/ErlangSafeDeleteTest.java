package org.intellij.erlang.refactoring;

public class ErlangSafeDeleteTest/* extends LightCodeInsightFixtureTestCase*/ {
  /*@Override
  protected void setUp() throws Exception {
    System.setProperty("idea.platform.prefix", "Idea");
    super.setUp();
  }

  @Override
    protected String getTestDataPath() {
      return "testData/refactoring/delete/";
    }
       */
  private void doTest() {
  /*  final String testName = getTestName(true);
    myFixture.configureByFile(testName + ".erl");
    PsiElement element = myFixture.getElementAtCaret();
    SafeDeleteHandler.invoke(myFixture.getProject(), new PsiElement[]{element}, false);
    myFixture.checkResultByFile(testName + "-after.erl");*/
  }

  public void testFunction()          throws Exception { doTest(); }
  public void testWithExports()       throws Exception { doTest(); }
}
