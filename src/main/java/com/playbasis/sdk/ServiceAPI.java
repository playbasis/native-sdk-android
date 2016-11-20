package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerServiceAPIComponent;
import com.playbasis.pbcore.dependency.module.ServiceModule;

/**
 * Created by Nott on 20/11/2559.
 * playbasis-sdk-android-project
 */

public class ServiceAPI {

  private static ServiceAPI serviceAPI;

  public static ServiceAPI instance() {
    if (serviceAPI == null) {
      serviceAPI = new ServiceAPI();

      DaggerServiceAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .serviceModule(new ServiceModule())
          .build()
          .inject(serviceAPI);
    }

    return serviceAPI;
  }
}
