package com.playbasis.pbcore.rest.form;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class VerifyGoodsCouponForm extends PBForm {

  private String goodsId;
  private String code;

  public VerifyGoodsCouponForm(String goodsId, String code) {
    this.goodsId = goodsId;
    this.code = code;
  }

  public String getGoodsId() {
    return goodsId;
  }

  public String getCode() {
    return code;
  }
}
