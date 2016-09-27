package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerHealthAPIComponent;
import com.playbasis.pbcore.dependency.module.HealthModule;

/**
 * Created by Tar on 8/19/16 AD.
 */
public class HealthAPI {

  private static HealthAPI healthAPI;

  public static HealthAPI instance() {
    if (healthAPI == null) {
      healthAPI = new HealthAPI();

      DaggerHealthAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .healthModule(new HealthModule())
          .build()
          .inject(healthAPI);
    }

    return healthAPI;
  }
}
