package com.playbasis.pbcore.rest.result.content;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.PBApiResult;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class CountContentApiResult extends PBApiResult<CountContentApiResult.Result> {

  public static final String TAG = "CountContentApiResult";

  public int getContentCount() {
    return response.resultCount;
  }

  public class Result {

    @SerializedName("result")
    public int resultCount;

  }

}
