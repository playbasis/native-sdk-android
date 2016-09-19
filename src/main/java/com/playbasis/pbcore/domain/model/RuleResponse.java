package com.playbasis.pbcore.domain.model;

import android.os.Parcel;

import com.playbasis.pbcore.rest.response.EventMissionResponse;
import com.playbasis.pbcore.rest.response.EventQuestResponse;
import com.playbasis.pbcore.rest.response.EventResponse;

import java.util.List;

/**
 * Created by Tar on 8/25/16 AD.
 */
public class RuleResponse extends PBModel {

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

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeTypedList(this.events);
    dest.writeTypedList(this.missions);
    dest.writeTypedList(this.quests);
  }

  protected RuleResponse(Parcel in) {
    this.events = in.createTypedArrayList(Event.CREATOR);
    this.missions = in.createTypedArrayList(Mission.CREATOR);
    this.quests = in.createTypedArrayList(Quest.CREATOR);
  }

  public static final Creator<RuleResponse> CREATOR = new Creator<RuleResponse>() {
    @Override
    public RuleResponse createFromParcel(Parcel source) {
      return new RuleResponse(source);
    }

    @Override
    public RuleResponse[] newArray(int size) {
      return new RuleResponse[size];
    }
  };
}
