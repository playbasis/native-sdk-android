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

public class RetrieveGameSettingApiResult extends PBApiResult<List<RetrieveGameSettingApiResult.Response>> {
  public static final String TAG = "RetrieveGameSettingResu";

  public class Response {
    @Expose
    @SerializedName("game_name")
    public String gameName;
    @Expose
    @SerializedName("date_added")
    public Date dateAdded;
    @Expose
    @SerializedName("date_modified")
    public Date dateModified;
    @Expose
    @SerializedName("image")
    public String imageUrl;
    @Expose
    @SerializedName("duration")
    public String duration;
    @Expose
    @SerializedName("stage")
    public List<GameStageResponse> gameStages;
  }

}
