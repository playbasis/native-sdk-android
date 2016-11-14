package com.playbasis.pbcore.rest.result.badge;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.response.BadgeResponse;
import com.playbasis.pbcore.rest.result.PBApiResult;
import com.playbasis.pbcore.rest.result.badge.AllBadgesApiResult.AllBadgesResponse;

import java.util.List;

/**
 * Created by Tar on 6/20/16 AD.
 */
public class AllBadgesApiResult extends PBApiResult<AllBadgesResponse> {

  public List<BadgeResponse> getBadgesResponse() {
    return response.badgeResponses;
  }

  public class AllBadgesResponse {
    @SerializedName("badges")
    List<BadgeResponse> badgeResponses;
  }

}
