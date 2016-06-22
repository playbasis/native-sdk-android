package com.playbasis.pbcore.rest.result;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.response.QuestResponse;

import java.util.List;

/**
 * Created by Tar on 6/22/16 AD.
 */
public class QuestListApiResult extends PBApiResult<QuestListApiResult.Response> {

  public List<QuestResponse> getQuestResponses() {
    return response.questResponses;
  }

  public class Response {

    @SerializedName("quests")
    List<QuestResponse> questResponses;

  }

}
