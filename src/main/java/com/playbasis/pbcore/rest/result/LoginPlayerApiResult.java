package com.playbasis.pbcore.rest.result;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class LoginPlayerApiResult extends BaseUserApiResult<LoginPlayerApiResult.Response> {

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
