package com.playbasis.pbcore.rest.form.goods;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class VerifyGoodsCouponForm extends PBForm {

  private String goodsId;
  private String code;
  private String playerId;

  public VerifyGoodsCouponForm(String goodsId, String code) {
    this.goodsId = goodsId;
    this.code = code;
  }

  public void setPlayerId(String playerId) {
    this.playerId = playerId;
  }

  public String getGoodsId() {
    return goodsId;
  }

  public String getCode() {
    return code;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("player_id", playerId);

    return map;
  }
}
