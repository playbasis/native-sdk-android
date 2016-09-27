package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerTripAPIComponent;
import com.playbasis.pbcore.dependency.module.TripModule;

/**
 * Created by Tar on 8/19/16 AD.
 */
public class TripAPI {

  private static TripAPI tripAPI;

  public static TripAPI instance() {
    if (tripAPI == null) {
      tripAPI = new TripAPI();

      DaggerTripAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .tripModule(new TripModule())
          .build()
          .inject(tripAPI);
    }

    return tripAPI;
  }
}
