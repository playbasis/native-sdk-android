package com.playbasis.pbcore.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Tar on 6/21/16 AD.
 */
public class QuestLeaderboardResponse {

  @Expose
  @SerializedName("current")
  public int current;
  @Expose
  @SerializedName("date_completed")
  public Date completedDate;
  @Expose
  @SerializedName("status")
  public String status;
  @Expose
  @SerializedName("goal")
  public int goal;
  @Expose
  @SerializedName("player")
  public PlayerResponse playerResponse;

}
