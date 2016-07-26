package com.playbasis.pbcore.rest.result.player;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.response.PointResponse;
import com.playbasis.pbcore.rest.result.PBApiResult;

import java.util.List;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class PlayerPointsApiResult extends PBApiResult<PlayerPointsApiResult.Response> {

  public List<PointResponse> getPointResponses() {
    return response.pointResponses;
  }

  public class Response {

    @SerializedName("points")
    List<PointResponse> pointResponses;

  }
}
