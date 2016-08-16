package com.playbasis.pbcore.rest.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.playbasis.pbcore.rest.result.player.GetUserCustomFieldsApiResult.PlayerCustomFieldResponse;

import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * Created by androiddev01 on 5/12/2016 AD.
 */
public class PlayerCustomFieldAdapter implements JsonDeserializer<PlayerCustomFieldResponse> {

  public PlayerCustomFieldResponse deserialize(JsonElement json, Type typeOfT,
                                               JsonDeserializationContext context) {
    PlayerCustomFieldResponse playerCustomFieldResponse = new PlayerCustomFieldResponse();
    if (json.isJsonArray()) {
      playerCustomFieldResponse.customFieldMap = null;
    } else if (json.isJsonObject()) {
      playerCustomFieldResponse.customFieldMap = context.deserialize(json.getAsJsonObject().getAsJsonObject("custom"), HashMap.class);
    } else {
      throw new RuntimeException("Unexpected JSON type: " + json.getClass());
    }
    return playerCustomFieldResponse;
  }
}
