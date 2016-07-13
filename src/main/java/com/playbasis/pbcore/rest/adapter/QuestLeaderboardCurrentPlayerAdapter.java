package com.playbasis.pbcore.rest.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.playbasis.pbcore.rest.response.QuestPlayerRankResponse;
import com.playbasis.pbcore.rest.result.quest.QuestLeaderboardApiResult;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by androiddev01 on 5/12/2016 AD.
 */
public class QuestLeaderboardCurrentPlayerAdapter implements JsonDeserializer<QuestLeaderboardApiResult.Response> {

  public QuestLeaderboardApiResult.Response deserialize(JsonElement json, Type typeOfT,
                                                        JsonDeserializationContext context) {
    JsonObject object = json.getAsJsonObject();
    QuestLeaderboardApiResult.Response questLeaderboardResponse = new QuestLeaderboardApiResult.Response();
    questLeaderboardResponse.questPlayerRankResponses = context.deserialize(object.getAsJsonArray("result"), new TypeToken<List<QuestPlayerRankResponse>>(){}.getType());

    if (object.get("player_data").isJsonArray()) {
      questLeaderboardResponse.currentPlayerRankResponses = null;
    } else if (object.get("player_data").isJsonObject()) {
      questLeaderboardResponse.currentPlayerRankResponses = context.deserialize(object.getAsJsonObject("player_data"), QuestPlayerRankResponse.class);
    } else {
      throw new RuntimeException("Unexpected JSON type: " + json.getClass());
    }

    return questLeaderboardResponse;
  }
}
