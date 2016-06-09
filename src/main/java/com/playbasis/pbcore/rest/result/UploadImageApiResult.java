package com.playbasis.pbcore.rest.result;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class UploadImageApiResult extends PBApiResult<UploadImageApiResult.Response> {

  public class Response {
    @SerializedName("url")
    public String url;
    @SerializedName("thumb_small")
    public String thumbSmall;
    @SerializedName("thumb_large")
    public String thumbLarge;
  }
}
