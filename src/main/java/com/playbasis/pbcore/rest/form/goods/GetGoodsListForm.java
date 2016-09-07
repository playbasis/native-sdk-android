package com.playbasis.pbcore.rest.form.goods;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetGoodsListForm extends PBForm {

  private String playerId;
  private String tags;

  public GetGoodsListForm() {

  }

  public void setPlayerId(String playerId) {
    this.playerId = playerId;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("player_id", playerId);
    map.put("tags", tags);

    return map;
  }
}
