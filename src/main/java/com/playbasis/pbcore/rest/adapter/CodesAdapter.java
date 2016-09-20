package com.playbasis.pbcore.rest.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.playbasis.pbcore.rest.response.GoodsResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by androiddev01 on 5/12/2016 AD.
 */
public class CodesAdapter extends BaseGsonAdapter implements JsonDeserializer<GoodsResponse.CodeResponse> {

  public GoodsResponse.CodeResponse deserialize(JsonElement json, Type typeOfT,
                                                JsonDeserializationContext context) {
    GoodsResponse.CodeResponse codeResponse = new GoodsResponse.CodeResponse();
    codeResponse.codes = new ArrayList<>();

    if (json.isJsonPrimitive()) {
      String code = context.deserialize(json, String.class);
      codeResponse.codes.add(code);
    } else if (json.isJsonArray()) {
      ArrayList<String> list = context.deserialize(json, ArrayList.class);
      codeResponse.codes.addAll(list);
    }

    return codeResponse;
  }
}
