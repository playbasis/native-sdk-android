package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.response.EventMissionResponse;
import com.playbasis.pbcore.rest.response.EventQuestResponse;
import com.playbasis.pbcore.rest.response.EventResponse;

import java.util.List;

/**
 * Created by Tar on 8/25/16 AD.
 */
public class RuleResponse {

  protected List<? extends Event> events;
  protected List<? extends Mission> missions;
  protected List<? extends Quest> quests;

  public RuleResponse(List<EventResponse> eventResponses, List<EventMissionResponse> missionResponses, List<EventQuestResponse> questResponses) {
    events = Event.createEvents(eventResponses);
    missions = Mission.createMissions(missionResponses);
    quests = Quest.createQuests(questResponses);
  }

  public List<? extends Event> getEvents() {
    return events;
  }

  public List<? extends Mission> getMissions() {
    return missions;
  }

  public List<? extends Quest> getQuests() {
    return quests;
  }
}
