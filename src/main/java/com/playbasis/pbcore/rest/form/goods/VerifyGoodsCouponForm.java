package com.playbasis.pbcore.rest.form.goods;

import com.playbasis.pbcore.rest.form.PBForm;

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

  public VerifyGoodsCouponForm(String goodsId, String code, String playerId) {
    this.goodsId = goodsId;
    this.playerId = playerId;
    this.code = code;
  }

  public String getGoodsId() {
    return goodsId;
  }

  public String getCode() {
    return code;
  }

  public String getPlayerId() {
    return playerId;
  }
}
