package com.playbasis.pbcore.rest.result;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tar on 4/21/16 AD.
 */
public abstract class PBApiResult<T> {

  @SerializedName("success")
  public Boolean success;
  @SerializedName("error_code")
  public String errorCode;
  @SerializedName("message")
  public String message;
  @SerializedName("timestamp")
  public Long timeStamp;
  @SerializedName("time")
  public String time;
  @SerializedName("version")
  public String version;
  @SerializedName("response")
  public T response;
}
