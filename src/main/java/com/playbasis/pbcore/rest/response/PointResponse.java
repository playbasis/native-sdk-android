package com.playbasis.pbcore.rest.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tar on 7/26/16 AD.
 */
public class PointResponse {

  @SerializedName("reward_id")
  public String id;
  @SerializedName("reward_name")
  public String name;
  @SerializedName("value")
  public int value;

}
