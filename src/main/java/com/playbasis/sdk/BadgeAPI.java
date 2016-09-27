package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerBadgeAPIComponent;
import com.playbasis.pbcore.dependency.module.BadgeModule;

/**
 * Created by Tar on 8/19/16 AD.
 */
public class BadgeAPI {

  private static BadgeAPI badgeAPI;

  public static BadgeAPI instance() {
    if (badgeAPI == null) {
      badgeAPI = new BadgeAPI();

      DaggerBadgeAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .badgeModule(new BadgeModule())
          .build()
          .inject(badgeAPI);
    }

    return badgeAPI;
  }
}
