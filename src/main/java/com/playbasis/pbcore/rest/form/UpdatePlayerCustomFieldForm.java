package com.playbasis.pbcore.rest.form;

import com.playbasis.pbcore.domain.model.Player;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class UpdatePlayerCustomFieldForm extends CustomFieldForm {

  protected String playerId;

  public UpdatePlayerCustomFieldForm(Player player) {
    this.playerId = player.playerId;
    this.customFieldMap = player.customFieldMap;
  }

  public UpdatePlayerCustomFieldForm(Player player, String key, String value) {
    this(player);

    setCustomField(key, value);
  }

  public String getPlayerId() {
    return playerId;
  }
}
