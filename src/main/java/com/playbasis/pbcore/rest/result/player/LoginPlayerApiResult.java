package com.playbasis.pbcore.rest.result.player;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.BasePlayerApiResult;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class LoginPlayerApiResult extends BasePlayerApiResult<LoginPlayerApiResult.Response> {

  @Override
  public String getUserId() {
    return response.userId;
  }

  public class Response{
    @SerializedName("cl_player_id")
    public String userId;
    @SerializedName("session_id")
    public String sessionId;
  }
}
