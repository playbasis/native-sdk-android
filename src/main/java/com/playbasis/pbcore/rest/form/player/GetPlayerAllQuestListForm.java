package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.PBForm;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetPlayerAllQuestListForm extends PBForm {

  private String playerId;

  public GetPlayerAllQuestListForm(String playerId) {
    this.playerId = playerId;
  }

  public String getPlayerId() {
    return playerId;
  }
}
