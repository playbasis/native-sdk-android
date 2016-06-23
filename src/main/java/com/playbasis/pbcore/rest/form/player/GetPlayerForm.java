package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.PBForm;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetPlayerForm extends PBForm {

  protected String playerId;

  public GetPlayerForm(String playerId) {
    this.playerId = playerId;
  }

  public String getPlayerId() {
    return playerId;
  }
}
