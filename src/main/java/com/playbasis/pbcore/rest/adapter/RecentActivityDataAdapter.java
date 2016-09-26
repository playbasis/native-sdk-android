package com.playbasis.pbcore.rest.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.playbasis.pbcore.rest.response.PlayerResponse;
import com.playbasis.pbcore.rest.response.RecentActivityResponse;

import java.lang.reflect.Type;

/**
 * Created by Tar on 6/29/16 AD.
 */
public class RecentActivityDataAdapter  extends BaseGsonAdapter implements JsonDeserializer<RecentActivityResponse>  {

  @Override
  public RecentActivityResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

    JsonObject jsonObject = (JsonObject) json;

    RecentActivityResponse recentActivityResponse = new RecentActivityResponse();
    recentActivityResponse.id = getString(jsonObject, "id");
    recentActivityResponse.actionIcon = getString(jsonObject, "action_icon");
    recentActivityResponse.actionName = getString(jsonObject, "action_name");
    recentActivityResponse.eventType = getString(jsonObject, "event_type");
    recentActivityResponse.stringFilter = getString(jsonObject, "string_filter");
    recentActivityResponse.dateAdded = getDate(jsonObject, "date_added", context);

    if (jsonObject.has("player")) {
      recentActivityResponse.playerResponse = context.deserialize(jsonObject.get("player"), PlayerResponse.class);
    }

    if (recentActivityResponse.eventType != null) {
      if (recentActivityResponse.eventType.equalsIgnoreCase("reward")) {
        recentActivityResponse.data = context.deserialize(json, RecentActivityResponse.ActionResponse.class);
      } else if (recentActivityResponse.eventType.equalsIgnoreCase("action")) {
        recentActivityResponse.data = context.deserialize(json, RecentActivityResponse.RewardResponse.class);
      } else if (recentActivityResponse.eventType.equalsIgnoreCase("redeem")) {
        recentActivityResponse.data = context.deserialize(json, RecentActivityResponse.RedeemResponse.class);
      } else if (recentActivityResponse.eventType.equalsIgnoreCase("level")) {
        recentActivityResponse.data = context.deserialize(json, RecentActivityResponse.LevelResponse.class);
      }
    }

    return recentActivityResponse;
  }
}
