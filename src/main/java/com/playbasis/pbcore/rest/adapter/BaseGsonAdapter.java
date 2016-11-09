package com.playbasis.pbcore.rest.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;

import java.util.Date;

/**
 * Created by Tar on 9/20/16 AD.
 */
public class BaseGsonAdapter {

  public int getInt(JsonObject json, String key) {
    if (hasValueForKey(json, key)) {
      return json.get(key).getAsInt();
    }

    return 0;
  }

  public String getString(JsonObject json, String key) {
    if (hasValueForKey(json, key)) {
      return json.get(key).getAsString();
    }

    return null;
  }

  public boolean getBoolean(JsonObject json, String key) {
    if (hasValueForKey(json, key)) {
      return json.get(key).getAsBoolean();
    }

    return false;
  }

  public double getDouble(JsonObject json, String key) {
    if (hasValueForKey(json, key)) {
      return json.get(key).getAsDouble();
    }

    return 0;
  }

  public long getLong(JsonObject json, String key) {
    if (hasValueForKey(json, key)) {
      return json.get(key).getAsLong();
    }

    return 0;
  }

  public float getFloat(JsonObject json, String key) {
    if (hasValueForKey(json, key)) {
      return json.get(key).getAsFloat();
    }

    return 0;
  }

  public Date getDate(JsonObject json, String key, JsonDeserializationContext context) {
    if (hasValueForKey(json, key)) {
      return context.deserialize(json.get(key), Date.class);
    }

    return null;
  }

  private boolean hasValueForKey(JsonObject jsonObject, String key) {
    return jsonObject.has(key) && jsonObject.get(key) != null;
  }
}
