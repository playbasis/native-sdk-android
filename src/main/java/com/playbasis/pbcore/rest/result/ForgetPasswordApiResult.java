package com.playbasis.pbcore.rest.result;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class ForgetPasswordApiResult extends PBApiResult<ForgetPasswordApiResult.Response> {

  public class Response{
    @SerializedName("success")
    public boolean success;
  }
}
