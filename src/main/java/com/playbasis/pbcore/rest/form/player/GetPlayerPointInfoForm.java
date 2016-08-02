package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.PBForm;

/**
 * Created by Tar on 6/10/16 AD.
 */
public class GetPlayerPointInfoForm extends PBForm {

  protected String playerId;
  protected String pointName;

  public GetPlayerPointInfoForm(String playerId, String pointName) {
    this.playerId = playerId;
    this.pointName = pointName;
  }

  public String getPlayerId() {
    return playerId;
  }

  public String getPointName() {
    return pointName;
  }
}
