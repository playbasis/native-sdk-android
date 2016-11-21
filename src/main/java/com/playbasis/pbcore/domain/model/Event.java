package com.playbasis.pbcore.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

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
  protected String transactionId;
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
    transactionId = eventResponse.transactionId;
    reward = new Reward(eventResponse.rewardResponse);
  }

  public String getType() {
    return type;
  }

  public String getLogId() {
    return logId;
  }

  public int getIndex() {
    return index;
  }

  public Reward getReward() {
    return reward;
  }

  public String getTransactionId() {
    return transactionId;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.type);
    dest.writeString(this.logId);
    dest.writeInt(this.index);
    dest.writeString(this.transactionId);
    dest.writeParcelable(this.reward, flags);
  }

  protected Event(Parcel in) {
    this.type = in.readString();
    this.logId = in.readString();
    this.index = in.readInt();
    this.transactionId = in.readString();
    this.reward = in.readParcelable(Reward.class.getClassLoader());
  }

  public static final Creator<Event> CREATOR = new Creator<Event>() {
    @Override
    public Event createFromParcel(Parcel source) {
      return new Event(source);
    }

    @Override
    public Event[] newArray(int size) {
      return new Event[size];
    }
  };
}
