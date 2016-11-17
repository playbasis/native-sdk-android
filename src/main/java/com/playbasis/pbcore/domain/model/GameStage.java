package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.response.GameStageResponse;

/**
 * Created by Nott on 17/11/2559.
 * DBS-SDK
 */

public class GameStage {
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
}
