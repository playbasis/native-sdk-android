package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerCompaignAPIComponent;
import com.playbasis.pbcore.dependency.module.CampaignModule;

/**
 * Created by Nott on 24/11/2559.
 * playbasis-sdk-android-project
 */

public class CampaignAPI {
  private static CampaignAPI campaignAPI;

  public static CampaignAPI instance() {
    if (campaignAPI == null) {
      campaignAPI = new CampaignAPI();

      DaggerCompaignAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .campaignModule(new CampaignModule())
          .build()
          .inject(campaignAPI);
    }

    return campaignAPI;
  }
}
