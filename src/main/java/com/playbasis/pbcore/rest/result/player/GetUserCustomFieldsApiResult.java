package com.playbasis.pbcore.rest.result.player;

import com.google.gson.annotations.SerializedName;

import com.playbasis.pbcore.rest.result.PBApiResult;
import com.playbasis.pbcore.rest.response.PlayerCustomFieldResponse;
import java.util.HashMap;

/**
 * Created by androiddev01 on 4/26/2016 AD.
 */
public class GetUserCustomFieldsApiResult extends PBApiResult<GetUserCustomFieldsApiResult.Response> {
  public static final String TAG = "GetUserCustomFieldsApiResult";

  public HashMap<String, String> getCustomFieldMap() {
    return response.player.customFieldMap;
  }

  public class Response {

    @SerializedName("player")
    public PlayerCustomFieldResponse player;

  }
}
