package com.playbasis.pbcore.rest.result.player;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.PBApiResult;
import com.playbasis.pbcore.rest.response.PlayerQuestResponse;

/**
 * Created by Tar on 6/22/16 AD.
 */
public class PlayerQuestApiResult extends PBApiResult<PlayerQuestApiResult.Response> {

  public PlayerQuestResponse getPlayerQuestResponse() {
    return response.questResponse;
  }

  public class Response {

    @SerializedName("quest")
    public PlayerQuestResponse questResponse;

  }

}
