package com.playbasis.pbcore.rest.form.goods;

import com.playbasis.pbcore.rest.form.PBForm;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetGoodsInfoForm extends PBForm {

  private String goodsId;
  private String playerId;

  public GetGoodsInfoForm(String goodsId) {
    this.goodsId = goodsId;
  }

  public GetGoodsInfoForm(String goodsId, String playerId) {
    this.goodsId = goodsId;
    this.playerId = playerId;
  }

  public String getGoodsId() {
    return goodsId;
  }

  public String getPlayerId() {
    return playerId;
  }
}
