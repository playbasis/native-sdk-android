package com.playbasis.pbcore.rest.result;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.response.ContentResponse;

import java.util.List;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class ContentsApiResult extends PBApiResult<ContentsApiResult.Result> {

  public static final String TAG = "ContentsApiResult";

  public List<ContentResponse> getContentResponses() {
    return response.contentResponses;
  }

  public class Result {

    @SerializedName("result")
    List<ContentResponse> contentResponses;

  }

}
