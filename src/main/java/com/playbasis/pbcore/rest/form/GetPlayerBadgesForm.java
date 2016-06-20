package com.playbasis.pbcore.rest.form;

import com.playbasis.pbcore.domain.model.Player;

/**
 * Created by Tar on 6/10/16 AD.
 */
public class GetPlayerBadgesForm extends PBForm {

  public Player player;

  public GetPlayerBadgesForm(Player player) {
    this.player = player;
  }

  public String getPlayerId() {
    if (player == null) {
      return null;
    }

    return player.getPlayerId();
  }
}
