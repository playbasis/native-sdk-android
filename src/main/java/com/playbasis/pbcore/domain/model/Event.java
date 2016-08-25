package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.response.EventResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tar on 8/25/16 AD.
 */
public class Event extends PBModel {

  protected String type;
  protected String logId;
  protected int index;
  protected Reward reward;

  public Event(EventResponse eventResponse) {
    update(eventResponse);
  }

  public static ArrayList<Event> createEvents(List<EventResponse> responses) {
    ArrayList<Event> events = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return events;
    }

    for (EventResponse response : responses) {
      events.add(new Event(response));
    }

    return events;
  }

  public void update(EventResponse eventResponse) {
    type = eventResponse.eventType;
    logId = eventResponse.logId;
    index = eventResponse.index;
    reward = new Reward(eventResponse.rewardResponse);
  }

}
