package com.playbasis.pbcore.rest.result.quest;

import com.playbasis.pbcore.rest.result.PBApiResult;
import com.playbasis.pbcore.rest.response.MissionResponse;

/**
 * Created by Tar on 6/22/16 AD.
 */
public class MissionInfoApiResult extends PBApiResult<MissionResponse> {

  public MissionResponse getMissionResponse() {
    return response;
  }

}
