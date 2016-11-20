package com.playbasis.pbcore.rest.result.game;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.response.ActiveCampaignResponse;
import com.playbasis.pbcore.rest.result.PBApiResult;

/**
 * Created by Nott on 17/11/2559.
 * DBS-SDK
 */

public class RetrieveActiveCampaignApiResult extends PBApiResult<RetrieveActiveCampaignApiResult.Response> {
  public static final String TAG = "RetrieveGameSettingResu";

  public class Response {
    @Expose
    @SerializedName("result")
    public ActiveCampaignResponse response;
  }
}
