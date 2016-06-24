package com.playbasis.pbcore.rest.result.quest;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.response.QuestPlayerRankResponse;
import com.playbasis.pbcore.rest.result.PBApiResult;

import java.util.List;

/**
 * Created by Tar on 6/22/16 AD.
 */
public class QuestLeaderboardApiResult extends PBApiResult<QuestLeaderboardApiResult.Response> {

  public List<QuestPlayerRankResponse> getQuestLeaderboardResponses() {
    return response.questPlayerRankResponses;
  }

  public class Response {

    @SerializedName("result")
    public List<QuestPlayerRankResponse> questPlayerRankResponses;

  }

}
