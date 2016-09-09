package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetPlayerAllQuestListForm extends PBForm {

  private String playerId;

  public GetPlayerAllQuestListForm(String playerId) {
    this.playerId = playerId;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    return map;
  }

  public String getPlayerId() {
    return playerId;
  }
}
