package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.PBForm;

/**
 * Created by Tar on 6/10/16 AD.
 */
public class GetPlayerGoodsForm extends PBForm {

  public String playerId;

  public GetPlayerGoodsForm(String playerId) {
    this.playerId = playerId;
  }

  public String getPlayerId() {
    return playerId;
  }
}
