package com.playbasis.pbcore.rest.result.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tar on 5/5/16 AD.
 */
public class RewardResponse {

  @SerializedName("reward_id")
  public String rewardId;
  @SerializedName("reward_type")
  public String type;
  @SerializedName("reward_value")
  public String value;
  @SerializedName("reward_data")
  public GoodsResponse detail;


  public class GoodsResponse extends com.playbasis.pbcore.rest.result.response.GoodsResponse {

    @Expose
    @SerializedName("per_user")
    public int perUser;
    @Expose
    @SerializedName("status")
    public boolean status;
    @Expose
    @SerializedName("deleted")
    public boolean deleted;

  }

}
