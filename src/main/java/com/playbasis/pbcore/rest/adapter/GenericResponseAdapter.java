package com.playbasis.pbcore.rest.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.playbasis.pbcore.rest.response.GenericResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;

/**
 * Created by Tar on 6/29/16 AD.
 */
public class GenericResponseAdapter extends BaseGsonAdapter implements JsonDeserializer<GenericResponse> {

  @Override
  public GenericResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    GenericResponse response = new GenericResponse();
    response.response = json.toString();

    try {
      if (json.isJsonObject()) {
        response.obj = new JSONObject(response.response);
      } else if (json.isJsonArray()) {
        response.arr = new JSONArray(response.response);
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }

    return response;
  }
}
