package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.result.game.RetrieveActiveCampaignApiResult;
import com.playbasis.pbcore.rest.result.game.RetrieveGameSettingApiResult;

import java.util.Date;

/**
 * Created by Nott on 18/11/2559.
 * playbasis-sdk-android-project
 */

public class Campaign {
  public static final String TAG = "Campaign";

  public String name;
  public String imageUrl;
  public int weight;
  public Date startDate;
  public Date endDate;

  public Campaign() {
  }

  public Campaign(RetrieveActiveCampaignApiResult.Response response) {
    update(response);
  }

  public void update(RetrieveActiveCampaignApiResult.Response response) {
    if (response == null) {
      return;
    }

    this.name = response.name;
    this.imageUrl = response.imageUrl;
    this.weight = response.weight;
    this.imageUrl = response.imageUrl;
    this.startDate = response.startDate;
    this.endDate = response.endDate;
  }

  public String getName() {
    return name;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public int getWeight() {
    return weight;
  }

  public Date getStartDate() {
    return startDate;
  }

  public Date getEndDate() {
    return endDate;
  }


}
