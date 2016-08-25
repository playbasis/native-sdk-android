package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.response.EventMissionResponse;
import com.playbasis.pbcore.rest.response.EventQuestResponse;
import com.playbasis.pbcore.rest.response.EventResponse;

import java.util.List;

/**
 * Created by Tar on 8/25/16 AD.
 */
public class RuleResponse {

  List<? extends Event> events;
  List<? extends Mission> missions;
  List<? extends Quest> quests;

  public RuleResponse(List<EventResponse> eventResponses, List<EventMissionResponse> missionResponses, List<EventQuestResponse> questResponses) {
    events = Event.createEvents(eventResponses);
    missions = Mission.createMissions(missionResponses);
    quests = Quest.createQuests(questResponses);
  }
}
