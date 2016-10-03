package com.playbasis.pbcore.rest.form.redeem;

import com.playbasis.pbcore.rest.form.PBForm;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class VerifyGoodsGroupForm extends PBForm {

  protected String goodsGroup;
  protected String couponCode;
  protected String pinCode;

  public VerifyGoodsGroupForm(String goodsGroup, String couponCode, String pinCode) {
    this.goodsGroup = goodsGroup;
    this.couponCode = couponCode;
    this.pinCode = pinCode;
  }

  public String getGoodsGroup() {
    return goodsGroup;
  }

  public String getCouponCode() {
    return couponCode;
  }

  public String getPinCode() {
    return pinCode;
  }
}
