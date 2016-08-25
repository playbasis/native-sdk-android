package com.playbasis.pbcore.rest.result.Engine;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.response.EventMissionResponse;
import com.playbasis.pbcore.rest.response.EventQuestResponse;
import com.playbasis.pbcore.rest.response.EventResponse;
import com.playbasis.pbcore.rest.result.PBApiResult;

import java.util.List;

/**
 * Created by Tar on 4/26/16 AD.
 */
public class RuleApiResult extends PBApiResult<RuleApiResult.Response> {

  public List<EventResponse> getEventResponse() {
    return response.eventResponses;
  }

  public List<EventMissionResponse> getEventMissionResponse() {
    return response.eventMissionResponses;
  }

  public List<EventQuestResponse> getEventQuestResponse() {
    return response.eventQuestResponses;
  }

  public class Response {

    @SerializedName("events")
    public List<EventResponse> eventResponses;
    @SerializedName("events_missions")
    public List<EventMissionResponse> eventMissionResponses;
    @SerializedName("events_quests")
    public List<EventQuestResponse> eventQuestResponses;

  }

}
