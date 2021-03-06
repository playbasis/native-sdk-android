package com.playbasis.pbcore.rest.form.redeem;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class RedeemGoodsForm extends PBForm {

  protected String goodsId;
  protected String playerId;
  protected int amount = -1;

  public RedeemGoodsForm(String goodsId, String playerId) {
    this.goodsId = goodsId;
    this.playerId = playerId;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    if (amount >= 0) {
      map.put("amount", amount);
    }

    return map;
  }

  public String getGoodsId() {
    return goodsId;
  }

  public String getPlayerId() {
    return playerId;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }
}
