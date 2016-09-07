package com.playbasis.pbcore.rest.form.goods;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetGoodsInfoForm extends PBForm {

  private String goodsId;
  private String playerId;

  public GetGoodsInfoForm(String goodsId) {
    this.goodsId = goodsId;
  }

  public String getGoodsId() {
    return goodsId;
  }

  public void setPlayerId(String playerId) {
    this.playerId = playerId;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("player_id", playerId);

    return map;
  }
}
