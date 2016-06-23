package com.playbasis.pbcore.rest.result.player;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.PBApiResult;
import com.playbasis.pbcore.rest.response.PlayerResponse;

/**
 * Created by androiddev01 on 4/26/2016 AD.
 */
public class GetPlayerDetailApiResult extends PBApiResult<GetPlayerDetailApiResult.Response> {
  public static final String TAG = "GetPlayerDetailApiResult";

  public String getEmail() {
    if (response != null) {
      return response.PlayerResponse.email;
    }

    return null;
  }

  public class Response {

    @SerializedName("player")
    public PlayerResponse PlayerResponse;

  }
}
