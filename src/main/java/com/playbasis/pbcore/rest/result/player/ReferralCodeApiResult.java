package com.playbasis.pbcore.rest.result.player;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.PBApiResult;

/**
 * Created by Tar on 6/22/16 AD.
 */
public class ReferralCodeApiResult extends PBApiResult<ReferralCodeApiResult.Response> {

  public Response getResponse() {
    return response;
  }

  public class Response {

    @SerializedName("code")
    public String code;

  }

}
