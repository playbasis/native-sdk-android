package com.playbasis.pbcore.rest.form.campaign;

/**
 * Created by Nott on 18/11/2559.
 * playbasis-sdk-android-project
 */

public class RetrieveCampaignForm {
  public static final String TAG = "RetrieveCampaignForm";

  public String campaignName;

  public RetrieveCampaignForm(String campaignName) {
    this.campaignName = campaignName;
  }

  public String getCampaignName() {
    return campaignName;
  }

  public void setCampaignName(String campaignName) {
    this.campaignName = campaignName;
  }
}
