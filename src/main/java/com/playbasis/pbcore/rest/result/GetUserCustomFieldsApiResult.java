package com.playbasis.pbcore.rest.result;

import com.google.gson.annotations.SerializedName;

import com.playbasis.pbcore.rest.result.response.PlayerResponse;
import java.util.HashMap;

/**
 * Created by androiddev01 on 4/26/2016 AD.
 */
public class GetUserCustomFieldsApiResult extends PBApiResult<GetUserCustomFieldsApiResult.Response> {
  public static final String TAG = "GetUserInfoApiResult";

  public HashMap<String, String> getCustomFieldMap() {
    return response.player.customFieldMap;
  }

  public class Response {

    @SerializedName("player")
    public PlayerResponse player;

  }
}
