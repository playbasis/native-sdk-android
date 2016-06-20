package com.playbasis.pbcore.rest.form;

import com.playbasis.pbcore.domain.model.Player;

/**
 * Created by Tar on 6/10/16 AD.
 */
public class GetPlayerCustomFieldForm extends PBForm {

  protected Player player;

  public GetPlayerCustomFieldForm(Player player) {
    this.player = player;
  }

  public Player getPlayer() {
    return player;
  }
}
