package com.playbasis.pbcore.rest.form.goods;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetGoodsInfoForm extends PBForm {

  protected String goodsId;
  protected String playerId;

  public GetGoodsInfoForm(String goodsId) {
    this.goodsId = goodsId;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("player_id", playerId);

    return map;
  }

  public String getGoodsId() {
    return goodsId;
  }

  public String getPlayerId() {
    return playerId;
  }

  public void setPlayerId(String playerId) {
    this.playerId = playerId;
  }
}
