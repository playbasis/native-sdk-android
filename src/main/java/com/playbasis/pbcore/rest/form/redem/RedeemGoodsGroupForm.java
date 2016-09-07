package com.playbasis.pbcore.rest.form.redem;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class RedeemGoodsGroupForm extends PBForm {

  private String group;
  private String playerId;
  private int amount = -1;

  public RedeemGoodsGroupForm(String group, String playerId) {
    this.group = group;
    this.playerId = playerId;
  }

  public String getGroup() {
    return group;
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

    if (amount >= 0) {
      map.put("amount", amount);
    }

    return map;
  }
}
