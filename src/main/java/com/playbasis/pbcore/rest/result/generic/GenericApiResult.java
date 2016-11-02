package com.playbasis.pbcore.rest.result.generic;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.playbasis.pbcore.rest.response.GenericResponse;
import com.playbasis.pbcore.rest.result.PBApiResult;

/**
 * Created by Tar on 11/2/16.
 */

public class GenericApiResult extends PBApiResult<GenericResponse> {

  public String getString() {
    return response.str;
  }

  public JsonObject getJsonObject() {
    return response.obj;
  }

  public JsonArray getJsonArray() {
    return response.arr;
  }

}
