package com.example.testdeps;

import io.testomat.core.constants.PropertyNameConstants;
import io.testomat.testng.listener.TestNgListener;
import java.util.ArrayList;
import java.util.List;
import org.testng.ISuite;

public class TestomatTestRunListener extends TestNgListener {


  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public void onStart(ISuite suite) {
    System.setProperty("testomatio.listening", isEnabled() ? "true" : null);

    var runName = "some";
      System.setProperty(PropertyNameConstants.RUN_TITLE_PROPERTY_NAME, runName);
      System.setProperty(PropertyNameConstants.RUN_GROUP_PROPERTY_NAME, runName.split("/")[0]);
    var tags = createTestRunTags();
    var tagsString = tags != null ? " @" + String.join(" @", tags) : "";
    System.setProperty(PropertyNameConstants.RUN_TITLE_PROPERTY_NAME, runName);
    System.setProperty(PropertyNameConstants.ENVIRONMENT_PROPERTY_NAME, "prod");
    super.onStart(suite);
  }

  private List<String> createTestRunTags() {
    List<String> tags = new ArrayList<>();
    return tags.isEmpty() ? null : tags;
  }

}
