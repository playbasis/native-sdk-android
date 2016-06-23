package com.playbasis.pbcore.rest.form;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class RedeemGoodsCouponForm extends PBForm {

  private String goodsId;
  private String code;
  private String playerId;

  public RedeemGoodsCouponForm(String goodsId, String code, String playerId) {
    this.goodsId = goodsId;
    this.code = code;
    this.playerId = playerId;
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
