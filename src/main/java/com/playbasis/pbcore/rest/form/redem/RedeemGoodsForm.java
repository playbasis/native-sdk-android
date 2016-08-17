package com.playbasis.pbcore.rest.form.redem;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class RedeemGoodsForm extends PBForm {

  private String goodsId;
  private String playerId;
  private int amount = -1;

  public RedeemGoodsForm(String goodsId, String playerId) {
    this.goodsId = goodsId;
    this.playerId = playerId;
  }

  public String getGoodsId() {
    return goodsId;
  }

  public String getPlayerId() {
    return playerId;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    if (amount != -1) {
      map.put("amount", amount);
    }

    return map;
  }
}
