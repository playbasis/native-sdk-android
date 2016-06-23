package com.playbasis.pbcore.rest.result.content;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.PBApiResult;

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
