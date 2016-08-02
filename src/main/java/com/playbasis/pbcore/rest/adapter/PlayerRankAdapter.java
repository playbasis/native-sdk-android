package com.playbasis.pbcore.rest.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.playbasis.pbcore.rest.response.PlayerRankResponse;
import com.smartsoftasia.ssalibrary.helper.Validator;

import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * Created by androiddev01 on 5/12/2016 AD.
 */
public class PlayerRankAdapter implements JsonDeserializer<PlayerRankResponse> {

  public PlayerRankResponse deserialize(JsonElement json, Type typeOfT,
                                               JsonDeserializationContext context) {

    JsonObject jsonObject = json.getAsJsonObject();
    jsonObject.remove("pb_player_id");

    HashMap<String, String> hashMap = context.deserialize(jsonObject, PlayerRankResponse.PlayerRankHashMap.class);
    PlayerRankResponse playerRankResponse = new PlayerRankResponse();

    for (String key : hashMap.keySet()) {
      if (key.equals("player_id")) {
        playerRankResponse.playerId = hashMap.get(key);
      } else if (!Validator.isValid(playerRankResponse.sortBy) || !Validator.isValid(playerRankResponse.value)) {
        playerRankResponse.sortBy = key;
        playerRankResponse.value = Integer.valueOf(hashMap.get(key));
      }
    }

    return playerRankResponse;
  }
}
