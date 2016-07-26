package com.playbasis.pbcore.rest.result.player;

import com.playbasis.pbcore.rest.response.PointResponse;
import com.playbasis.pbcore.rest.result.PBApiResult;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class PlayerPointApiResult extends PBApiResult<PointResponse> {

  public PointResponse getPointResponse() {
    return response;
  }

}
