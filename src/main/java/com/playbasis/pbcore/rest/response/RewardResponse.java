package com.playbasis.pbcore.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Tar on 5/5/16 AD.
 */
public class RewardResponse {

  @SerializedName("reward_id")
  public String rewardId;
  @SerializedName("reward_type")
  public String rewardType;
  @SerializedName("reward_value")
  public String rewardValue;
  @SerializedName("reward_data")
  public RewardDataInterface data;


  public interface RewardDataInterface {

  }

  public class RewardGoodsResponse extends GoodsResponse implements RewardDataInterface {

    @Expose
    @SerializedName("date_added")
    public Date addedDate;
    @Expose
    @SerializedName("date_modified")
    public Date modifiedDate;
    @Expose
    @SerializedName("per_user")
    public int perUser;
    @Expose
    @SerializedName("deleted")
    public boolean deleted;

  }

  public class RewardBadgeResponse extends BadgeResponse implements RewardDataInterface {

    @Expose
    @SerializedName("claim")
    public boolean claim;
    @Expose
    @SerializedName("redeem")
    public boolean redeem;

  }

}
