package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.response.GameStageResponse;
import com.playbasis.pbcore.rest.result.game.RetrieveGameSettingApiResult;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Nott on 17/11/2559.
 * DBS-SDK
 */

public class GameSetting {
  public static final String TAG = "GameSetting";

  public String gameName;
  public Date dateAdded;
  public Date dateModified;
  public String imageUrl;
  public String duration;
  public List<GameStage> gameStages;

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
}
