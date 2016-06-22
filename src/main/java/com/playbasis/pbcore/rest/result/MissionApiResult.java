package com.playbasis.pbcore.rest.result;

import com.playbasis.pbcore.rest.result.response.MissionResponse;

/**
 * Created by Tar on 6/22/16 AD.
 */
public class MissionApiResult extends PBApiResult<MissionResponse> {

  public MissionResponse getMissionResponse() {
    return response;
  }

}
