package com.playbasis.pbcore.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tar on 5/5/16 AD.
 */
public class PlayerQuestResponse extends BaseQuestResponse<PlayerMissionResponse> {

  @Expose
  @SerializedName("player_status")
  public String playerStatus;
  @Expose
  @SerializedName("num_missions")
  public NumMissionsResponse numMissionsResponse;

  public class NumMissionsResponse {

    @Expose
    @SerializedName("total")
    public int total;
    @Expose
    @SerializedName("join")
    public int join;
    @Expose
    @SerializedName("unjoin")
    public int unjoin;
    @Expose
    @SerializedName("finish")
    public int finish;
  }

}
