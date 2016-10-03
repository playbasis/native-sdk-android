package com.playbasis.pbcore.rest.form.redeem;

import com.playbasis.pbcore.rest.form.CustomParamsForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class VerifyGoodsGroupForm extends CustomParamsForm {

  protected String goodsGroup;
  protected String couponCode;
  protected String pinCode;

  public VerifyGoodsGroupForm(String goodsGroup, String couponCode) {
    this.goodsGroup = goodsGroup;
    this.couponCode = couponCode;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("pin_code", pinCode);

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
}
