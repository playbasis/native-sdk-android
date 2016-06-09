package com.playbasis.pbcore.rest.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.playbasis.pbcore.rest.result.response.PlayerResponse;

import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * Created by androiddev01 on 5/12/2016 AD.
 */
public class GsonPlayerAdapter implements JsonDeserializer<PlayerResponse> {

  public PlayerResponse deserialize(JsonElement json, Type typeOfT,
                                    JsonDeserializationContext context) {
    PlayerResponse playerResponse = new PlayerResponse();
    if (json.isJsonArray()) {
      playerResponse.customFieldMap = null;
    } else if (json.isJsonObject()) {
      playerResponse.customFieldMap = context.deserialize(json.getAsJsonObject().getAsJsonObject("custom"), HashMap.class);
    } else {
      throw new RuntimeException("Unexpected JSON type: " + json.getClass());
    }
    return playerResponse;
  }
}
