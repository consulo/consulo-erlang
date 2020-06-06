package org.intellij.erlang.performance;

import org.intellij.erlang.highlighting.ErlangHighlightingTestBase;
import org.intellij.erlang.utils.ErlangLightPlatformCodeInsightFixtureTestCase;
import com.intellij.testFramework.PlatformTestUtil;
import com.intellij.util.ThrowableRunnable;

public abstract class ErlangPerformanceTest extends ErlangLightPlatformCodeInsightFixtureTestCase {
  @Override
  protected String getTestDataPath() {
    return "testData/performance/";
  }

  /*@Override
  protected LightProjectDescriptor getProjectDescriptor() {
    return new DefaultLightProjectDescriptor() {
      @Override
      public Sdk getSdk() {
        return ErlangSdkType.createMockSdk("testData/mockSdk-R15B02/");
      }
    };
  } */

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    ErlangHighlightingTestBase.setUpInspections(myFixture);
    setUpProjectSdk();
  }

  @Override
  protected boolean isWriteActionRequired() {
    return false;
  }

  protected void doTest(int expectedMs) {
    PlatformTestUtil.startPerformanceTest("erlang highlighting is slow", expectedMs, new ThrowableRunnable() {
      @Override
      public void run() throws Throwable {
        myFixture.configureByFile(getTestName(false) + ".erl");
        myFixture.doHighlighting();
      }
    }).attempts(100).cpuBound().usesAllCPUCores().assertTiming();
  }

  public void testDialyzerDataflow() throws Exception { doTest(5000); }
}
