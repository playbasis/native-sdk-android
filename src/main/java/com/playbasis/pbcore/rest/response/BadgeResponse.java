package com.playbasis.pbcore.rest.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tar on 5/5/16 AD.
 */
public class BadgeResponse implements RewardResponse.RewardDataInterface {

  @SerializedName("badge_id")
  public String badgeId;
  @SerializedName("image")
  public String imageUrl;
  @SerializedName("sort_order")
  public int sortOrder;
  @SerializedName("name")
  public String name;
  @SerializedName("description")
  public String description;
  @SerializedName("hint")
  public String hint;
  @SerializedName("sponsor")
  public boolean sponsor;
  @SerializedName("amount")
  public int amount;

}
