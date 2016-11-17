package com.playbasis.pbcore.domain.model;

import android.os.Parcel;

import com.playbasis.pbcore.rest.response.GameStageResponse;
import com.playbasis.pbcore.rest.result.game.RetrieveGameSettingApiResult;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Nott on 17/11/2559.
 * DBS-SDK
 */

public class GameSetting extends PBModel {
  public static final String TAG = "GameSetting";

  public String gameName;
  public Date dateAdded;
  public Date dateModified;
  public String imageUrl;
  public String duration;
  public String actionTime;
  public List<GameStage> gameStages;

  public GameSetting() {
  }

  public GameSetting(RetrieveGameSettingApiResult.Response response) {
    update(response);
  }

  public void update(RetrieveGameSettingApiResult.Response response) {
    if (response == null) {
      return;
    }

    this.gameName = response.gameName;
    this.dateAdded = response.dateAdded;
    this.dateModified = response.dateModified;
    this.imageUrl = response.imageUrl;
    this.duration = response.duration;
    this.actionTime = response.actionTime;
    this.gameStages = GameSetting.createGameStages(response.gameStages);
  }

  public static <T extends GameStageResponse> ArrayList<GameStage> createGameStages(List<T> responses) {
    ArrayList<GameStage> gameStages = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return gameStages;
    }

    for (T response : responses) {
      gameStages.add(new GameStage(response));
    }

    return gameStages;
  }

  public String getDuration() {
    return duration;
  }

  public String getActionTime() {
    return actionTime;
  }

  public static <T extends RetrieveGameSettingApiResult.Response> ArrayList<GameSetting> createGameSettings(List<T> responses) {
    ArrayList<GameSetting> gameSettings = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return gameSettings;
    }

    for (T response : responses) {
      gameSettings.add(new GameSetting(response));
    }

    return gameSettings;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.gameName);
    dest.writeLong(this.dateAdded != null ? this.dateAdded.getTime() : -1);
    dest.writeLong(this.dateModified != null ? this.dateModified.getTime() : -1);
    dest.writeString(this.imageUrl);
    dest.writeString(this.duration);
    dest.writeString(this.actionTime);
    dest.writeTypedList(this.gameStages);
  }

  protected GameSetting(Parcel in) {
    this.gameName = in.readString();
    long tmpDateAdded = in.readLong();
    this.dateAdded = tmpDateAdded == -1 ? null : new Date(tmpDateAdded);
    long tmpDateModified = in.readLong();
    this.dateModified = tmpDateModified == -1 ? null : new Date(tmpDateModified);
    this.imageUrl = in.readString();
    this.duration = in.readString();
    this.actionTime = in.readString();
    this.gameStages = in.createTypedArrayList(GameStage.CREATOR);
  }

  public static final Creator<GameSetting> CREATOR = new Creator<GameSetting>() {
    @Override
    public GameSetting createFromParcel(Parcel source) {
      return new GameSetting(source);
    }

    @Override
    public GameSetting[] newArray(int size) {
      return new GameSetting[size];
    }
  };
}
