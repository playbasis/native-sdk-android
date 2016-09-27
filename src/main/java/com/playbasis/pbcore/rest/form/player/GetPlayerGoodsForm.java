package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 6/10/16 AD.
 */
public class GetPlayerGoodsForm extends PBForm {

  public String playerId;
  public String tags;
  public String status;

  public GetPlayerGoodsForm(String playerId) {
    this.playerId = playerId;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("status", status);
    map.put("tags", tags);

    return map;
  }

  public String getPlayerId() {
    return playerId;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
