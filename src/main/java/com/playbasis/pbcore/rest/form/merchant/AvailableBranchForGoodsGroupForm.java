package com.playbasis.pbcore.rest.form.merchant;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 8/25/16 AD.
 */
public class AvailableBranchForGoodsGroupForm extends PBForm {

  protected String goodsGroup;

  public AvailableBranchForGoodsGroupForm(String goodsGroup) {
    this.goodsGroup = goodsGroup;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    return map;
  }

  public String getGoodsGroup() {
    return goodsGroup;
  }
}
