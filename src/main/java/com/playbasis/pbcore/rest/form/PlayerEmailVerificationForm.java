package com.playbasis.pbcore.rest.form;

/**
 * Created by Tar on 6/13/16 AD.
 */
public class PlayerEmailVerificationForm extends PBForm {

  protected String playerId;

  public PlayerEmailVerificationForm(String playerId) {
    this.playerId = playerId;
  }

  public String getPlayerId() {
    return playerId;
  }
}
