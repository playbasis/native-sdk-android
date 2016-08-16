package com.playbasis.pbcore.rest.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.playbasis.pbcore.rest.response.GoodsResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by androiddev01 on 5/12/2016 AD.
 */
public class CodesAdapter implements JsonDeserializer<GoodsResponse.CodeResponse> {

  public GoodsResponse.CodeResponse deserialize(JsonElement json, Type typeOfT,
                                                JsonDeserializationContext context) {
    GoodsResponse.CodeResponse codeResponse = new GoodsResponse.CodeResponse();
    codeResponse.codes = new ArrayList<>();

    JsonObject codesJson = json.getAsJsonObject();

    if (codesJson.isJsonArray()) {
      ArrayList<String> list = context.deserialize(codesJson, ArrayList.class);
      codeResponse.codes.addAll(list);
    } else if (codesJson.isJsonObject()) {
      String code = context.deserialize(codesJson, String.class);
      codeResponse.codes.add(code);
    }

    return codeResponse;
  }
}
