package com.playbasis.pbcore.rest.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.playbasis.pbcore.rest.response.RewardResponse;

import java.lang.reflect.Type;

/**
 * Created by Tar on 6/29/16 AD.
 */
public class RewardDataAdapter extends BaseGsonAdapter implements JsonDeserializer<RewardResponse.RewardDataInterface>  {

  @Override
  public RewardResponse.RewardDataInterface deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

    JsonObject jsonObject = (JsonObject) json;
    if (jsonObject.has("goods_id")) {
      return context.deserialize(json, RewardResponse.RewardGoodsResponse.class);
    } else if (jsonObject.has("badge_id")) {
      return context.deserialize(json, RewardResponse.RewardBadgeResponse.class);
    } else {
      return null;
    }
  }
}
