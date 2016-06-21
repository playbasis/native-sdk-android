package com.playbasis.pbcore.rest.form;

import com.playbasis.pbcore.domain.model.Player;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetGoodsListForm extends PBForm {

  private String playerId;
  private String tags;

  public GetGoodsListForm(Player player) {
    player.getPlayerId();
  }

  public GetGoodsListForm(Player player, String tags) {
    this.playerId = player.getPlayerId();
    this.tags = tags;
  }

  public String getPlayerId() {
    return playerId;
  }

  public String getTags() {
    return tags;
  }
}
