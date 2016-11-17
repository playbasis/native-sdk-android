package com.playbasis.pbcore.domain.model;

import android.os.Parcel;

import com.playbasis.pbcore.rest.response.GameStageResponse;

/**
 * Created by Nott on 17/11/2559.
 * DBS-SDK
 */

public class GameStage extends PBModel {
  public static final String TAG = "GameStage";

  public String stageName;
  public int stageLevel;
  public String imageUrl;
  public int rangeLow;
  public int rangeHeight;

  public GameStage(GameStageResponse gameStageResponse) {
    update(gameStageResponse);
  }

  public void update(GameStageResponse response) {
    if (response == null) {
      return;
    }

    this.stageName = response.stageName;
    this.stageLevel = response.stageLevel;
    this.imageUrl = response.imageUrl;
    this.rangeLow = response.rangeLow;
    this.rangeHeight = response.rangeHeight;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.stageName);
    dest.writeInt(this.stageLevel);
    dest.writeString(this.imageUrl);
    dest.writeInt(this.rangeLow);
    dest.writeInt(this.rangeHeight);
  }

  protected GameStage(Parcel in) {
    this.stageName = in.readString();
    this.stageLevel = in.readInt();
    this.imageUrl = in.readString();
    this.rangeLow = in.readInt();
    this.rangeHeight = in.readInt();
  }

  public static final Creator<GameStage> CREATOR = new Creator<GameStage>() {
    @Override
    public GameStage createFromParcel(Parcel source) {
      return new GameStage(source);
    }

    @Override
    public GameStage[] newArray(int size) {
      return new GameStage[size];
    }
  };
}
