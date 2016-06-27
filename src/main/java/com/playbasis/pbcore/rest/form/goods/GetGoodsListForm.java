package com.playbasis.pbcore.rest.form.goods;

import com.playbasis.pbcore.rest.form.PBForm;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetGoodsListForm extends PBForm {

  private String playerId;
  private String tags;

  public GetGoodsListForm() {

  }

  public GetGoodsListForm(String playerId, String tags) {
    this.playerId = playerId;
    this.tags = tags;
  }

  public String getPlayerId() {
    return playerId;
  }

  public String getTags() {
    return tags;
  }
}
