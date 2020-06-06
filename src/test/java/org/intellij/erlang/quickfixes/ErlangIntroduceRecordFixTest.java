package org.intellij.erlang.quickfixes;

import org.intellij.erlang.inspection.ErlangUnresolvedRecordInspection;

public abstract class ErlangIntroduceRecordFixTest extends ErlangQuickFixTestBase {

  @SuppressWarnings("unchecked")
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    myFixture.enableInspections(ErlangUnresolvedRecordInspection.class);
  }

  @Override
  protected String getTestDataPath() {
    return "testData/quickfixes/introduce_record/";
  }

  private void doIntroduceRecordTest()                        { doTest("Introduce new record"); }

  public void testSimple() throws Throwable                   { doIntroduceRecordTest(); }
  public void testWithPrecedingFunctions() throws Throwable   { doIntroduceRecordTest(); }
  public void testWithPrecedingRecords() throws Throwable     { doIntroduceRecordTest(); }
  public void testSurroundedByDeclarations() throws Throwable { doIntroduceRecordTest(); }
  public void testWithFields() throws Throwable               { doIntroduceRecordTest(); }
}
