package com.playbasis.pbcore.rest.result.quest;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.PBApiResult;
import com.playbasis.pbcore.rest.response.QuestResponse;

/**
 * Created by Tar on 6/22/16 AD.
 */
public class QuestInfoApiResult extends PBApiResult<QuestInfoApiResult.Response> {

  public QuestResponse getQuestResponse() {
    return response.questResponse;
  }

  public class Response {

    @SerializedName("quest")
    public QuestResponse questResponse;

  }

}
