package com.playbasis.pbcore.rest.result;

import com.google.gson.annotations.SerializedName;

/**
 * Created by androiddev01 on 5/11/2016 AD.
 */
public class CreateContentApiResult extends PBApiResult<CreateContentApiResult.Response> {
  public static final String TAG = "CreateContentApiResult";

  public class Response {

    @SerializedName("$id")
    public String id;

  }
}
