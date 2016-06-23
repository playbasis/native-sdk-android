package com.playbasis.pbcore.rest.result.player;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.PBApiResult;
import com.playbasis.pbcore.rest.response.PlayerQuestResponse;

import java.util.List;

/**
 * Created by Tar on 6/22/16 AD.
 */
public class PlayerQuestListApiResult extends PBApiResult<PlayerQuestListApiResult.Response> {

  public List<PlayerQuestResponse> getPlayerQuestResponses() {
    return response.questResponses;
  }

  public class Response {

    @SerializedName("quests")
    List<PlayerQuestResponse> questResponses;

  }

}
