package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.CustomParamsForm;

/**
 * Created by Tar on 6/10/16 AD.
 */
public class GetPlayerActionCountForm extends CustomParamsForm {

  public String playerId;
  public String actionName;

  public GetPlayerActionCountForm(String playerId, String actionName) {
    this.playerId = playerId;
    this.actionName = actionName;
  }

  public String getPlayerId() {
    return playerId;
  }

  public String getActionName() {
    return actionName;
  }
}
