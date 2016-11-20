package com.playbasis.pbcore.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Nott on 19/11/2559.
 * playbasis-sdk-android-project
 */

public class ActiveCampaignResponse {
  public static final String TAG = "ActiveCampaignRespone";

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
