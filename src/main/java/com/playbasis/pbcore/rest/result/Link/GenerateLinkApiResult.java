package com.playbasis.pbcore.rest.result.Link;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.PBApiResult;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GenerateLinkApiResult extends PBApiResult<GenerateLinkApiResult.Response> {

  public String getLink() {
    return response.link;
  }

  public class Response {

    @SerializedName("link")
    public String link;
  }
}
