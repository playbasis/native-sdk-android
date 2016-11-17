package com.playbasis.pbcore.rest.form.game;

/**
 * Created by Nott on 17/11/2559.
 * DBS-SDK
 */

public class RetrieveGameSettingsForm {
  public static final String TAG = "GameSettingsForm";

  public String gameName;

  public String getGameName() {
    return gameName;
  }

  public void setGameName(String gameName) {
    this.gameName = gameName;
  }
}
