package com.playbasis.pbcore.rest.result;

import com.google.gson.annotations.SerializedName;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class CountContentApiResult extends PBApiResult<CountContentApiResult.Result> {

  public static final String TAG = "CountContentApiResult";

  public int getIdeaCount() {
    return response.resultCount;
  }

  public class Result {

    @SerializedName("result")
    public int resultCount;

  }

}
