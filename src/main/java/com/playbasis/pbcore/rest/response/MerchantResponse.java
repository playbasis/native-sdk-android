package com.playbasis.pbcore.rest.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tar on 8/31/16 AD.
 */
public class MerchantResponse {

  @SerializedName("id")
  public String merchantId;
  @SerializedName("name")
  public String merchantName;
}
