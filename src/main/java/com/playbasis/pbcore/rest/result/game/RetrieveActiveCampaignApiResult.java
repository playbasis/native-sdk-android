package com.playbasis.pbcore.rest.result.game;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.response.GameStageResponse;
import com.playbasis.pbcore.rest.result.PBApiResult;

import java.util.Date;
import java.util.List;

/**
 * Created by Nott on 17/11/2559.
 * DBS-SDK
 */

public class RetrieveActiveCampaignApiResult extends PBApiResult<RetrieveActiveCampaignApiResult.Response> {
  public static final String TAG = "RetrieveGameSettingResu";

  public class Response {
    @Expose
    @SerializedName("name")
    public String name;
    @Expose
    @SerializedName("image")
    public String imageUrl;
    @Expose
    @SerializedName("weight")
    public int weight;
    @Expose
    @SerializedName("date_start")
    public Date startDate;
    @Expose
    @SerializedName("date_end")
    public Date endDate;
  }

}
