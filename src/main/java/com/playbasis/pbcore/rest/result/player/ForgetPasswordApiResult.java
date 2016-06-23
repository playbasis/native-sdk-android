package com.playbasis.pbcore.rest.result.player;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.PBApiResult;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class ForgetPasswordApiResult extends PBApiResult<ForgetPasswordApiResult.Response> {

  public class Response{
    @SerializedName("success")
    public boolean success;
  }
}
