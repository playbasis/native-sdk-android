package com.playbasis.pbcore.rest.result.point;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.PBApiResult;

import java.util.List;

/**
 * Created by Nott on 16/11/2559.
 * playbasis-sdk-android-project
 */

public class RemainingPointApiResult extends PBApiResult<List<RemainingPointApiResult.Response>> {

  public class Response {
    @Expose
    @SerializedName("name")
    public String name;
    @Expose
    @SerializedName("quantity")
    public String quantity;

  }
}
