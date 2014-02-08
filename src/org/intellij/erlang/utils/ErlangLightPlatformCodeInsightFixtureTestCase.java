package org.intellij.erlang.utils;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase;

public abstract class ErlangLightPlatformCodeInsightFixtureTestCase extends LightPlatformCodeInsightFixtureTestCase {

  protected ErlangLightPlatformCodeInsightFixtureTestCase() {
  }

  @Override
  protected void setUp() throws Exception {

    super.setUp();
  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
  }

  protected void setUpProjectSdk() {
    ApplicationManager.getApplication().runWriteAction(new Runnable() {
      @Override
      public void run() {
        /*final Sdk sdk = getProjectDescriptor().getSdk();
        ProjectJdkTable.getInstance().addJdk(sdk);
        ProjectRootManager.getInstance(myFixture.getProject()).setProjectSdk(sdk);  */
      }
    });
  }
}
