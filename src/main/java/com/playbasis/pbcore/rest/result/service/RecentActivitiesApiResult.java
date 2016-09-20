package com.playbasis.pbcore.rest.result.service;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.response.RecentActivityResponse;
import com.playbasis.pbcore.rest.result.PBApiResult;

import java.util.List;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class RecentActivitiesApiResult extends PBApiResult<RecentActivitiesApiResult.Response> {

  public List<RecentActivityResponse> getResponses() {
    return response.recentActivityResponses;
  }

  public class Response {

    @SerializedName("activities")
    public List<RecentActivityResponse> recentActivityResponses;
  }
}
