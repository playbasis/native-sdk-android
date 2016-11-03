package com.playbasis.pbcore.rest.result.generic;

import com.playbasis.pbcore.rest.response.GenericResponse;
import com.playbasis.pbcore.rest.result.PBApiResult;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Tar on 11/2/16.
 */

public class GenericApiResult extends PBApiResult<GenericResponse> {

  public String getResponse() {
    return response.response;
  }

  public JSONObject getJSONObjectResponse() {
    return response.obj;
  }

  public JSONArray getJSONArrayResponse() {
    return response.arr;
  }

}
