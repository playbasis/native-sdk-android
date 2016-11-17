package com.playbasis.pbcore.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nott on 17/11/2559.
 * DBS-SDK
 */

public class GameStageResponse {

  @Expose
  @SerializedName("stage_name")
  public String stageName;
  @Expose
  @SerializedName("stage_level")
  public int stageLevel;
  @Expose
  @SerializedName("image")
  public String imageUrl;
  @Expose
  @SerializedName("range_low")
  public int rangeLow;
  @Expose
  @SerializedName("range_high")
  public int rangeHeight;
}
