package com.playbasis.pbcore.domain.model;

import android.os.Parcel;

import com.playbasis.pbcore.rest.response.PlayerMissionResponse;

/**
 * Created by Tar on 6/30/16 AD.
 */
public class Incompletion extends PBModel {

  protected String incompletionId;
  protected String type;
  protected String value;
  protected String elementId;
  protected String filter;

  public Incompletion(PlayerMissionResponse.PendingResponse.IncompletionResponse incompletionResponse) {
    if (incompletionResponse == null) {
      return;
    }

    this.incompletionId = incompletionResponse.incompletionId;
    this.type = incompletionResponse.type;
    this.value = incompletionResponse.value;
    this.elementId = incompletionResponse.elementId;
    this.filter = incompletionResponse.filter;
  }

  public String getIncompletionId() {
    return incompletionId;
  }

  public String getType() {
    return type;
  }

  public String getValue() {
    return value;
  }

  public String getElementId() {
    return elementId;
  }

  public String getFilter() {
    return filter;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.incompletionId);
    dest.writeString(this.type);
    dest.writeString(this.value);
    dest.writeString(this.elementId);
    dest.writeString(this.filter);
  }

  protected Incompletion(Parcel in) {
    this.incompletionId = in.readString();
    this.type = in.readString();
    this.value = in.readString();
    this.elementId = in.readString();
    this.filter = in.readString();
  }

  public static final Creator<Incompletion> CREATOR = new Creator<Incompletion>() {
    @Override
    public Incompletion createFromParcel(Parcel source) {
      return new Incompletion(source);
    }

    @Override
    public Incompletion[] newArray(int size) {
      return new Incompletion[size];
    }
  };
}