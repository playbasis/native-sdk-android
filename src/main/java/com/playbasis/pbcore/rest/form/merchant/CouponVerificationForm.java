package com.playbasis.pbcore.rest.form.merchant;

import com.playbasis.pbcore.rest.form.CustomParamsForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class CouponVerificationForm extends CustomParamsForm {

  protected String goodsGroup;
  protected String couponCode;
  protected String pinCode;
  protected String playerId;

  public CouponVerificationForm(String goodsGroup, String couponCode) {
    this.goodsGroup = goodsGroup;
    this.couponCode = couponCode;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("pin_code", pinCode);
    map.put("player_id", playerId);

    return map;
  }

  public String getGoodsGroup() {
    return goodsGroup;
  }

  public String getCouponCode() {
    return couponCode;
  }

  public void setPinCode(String pinCode) {
    this.pinCode = pinCode;
  }

  public void setPlayerId(String playerId) {
    this.playerId = playerId;
  }
}
