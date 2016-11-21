package com.playbasis.pbcore.rest.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.playbasis.pbcore.rest.response.EventResponse;
import com.playbasis.pbcore.rest.response.RewardResponse;

import java.lang.reflect.Type;

/**
 * Created by Tar on 6/29/16 AD.
 */
public class EventAdapter extends BaseGsonAdapter implements JsonDeserializer<EventResponse> {

  @Override
  public EventResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

    EventResponse eventResponse = new EventResponse();

    if (json == null) {
      return eventResponse;
    }


    JsonObject jsonObject = (JsonObject) json;

    eventResponse.eventType = getString(jsonObject, "event_type");
    eventResponse.logId = getString(jsonObject, "log_id");
    eventResponse.index = getInt(jsonObject, "index");
    eventResponse.transactionId = getString(jsonObject, "transaction_id");

    if (jsonObject.has("value")) {
      jsonObject.addProperty("reward_value", jsonObject.get("value").getAsString());
    }

    eventResponse.rewardResponse = context.deserialize(jsonObject, RewardResponse.class);

    return eventResponse;
  }
}
