package com.playbasis.pbcore.rest.result.player;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.PBApiResult;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class PlayerActionCountApiResult extends PBApiResult<PlayerActionCountApiResult.Response> {

  public ActionResponse getActionResponse() {
    if (response == null) {
      return null;
    }

    return response.actionResponse;
  }

  public class Response {

    @SerializedName("action")
    public ActionResponse actionResponse;
  }

  public class ActionResponse {
    @SerializedName("action_id")
    public String actionId;
    @SerializedName("action_name")
    public String actionName;
    @SerializedName("count")
    public int count;
  }
}
