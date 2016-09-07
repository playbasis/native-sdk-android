package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 6/10/16 AD.
 */
public class GetPlayerRankingForm extends PBForm {

  protected String rankBy;
  protected int limit = 20;
  protected String mode = null;

  public GetPlayerRankingForm(String rankBy) {
    this.rankBy = rankBy;
  }

  public GetPlayerRankingForm(String rankBy, int limit) {
    this.rankBy = rankBy;
    this.limit = limit;
  }

  public String getRankBy() {
    return rankBy;
  }

  public int getLimit() {
    return limit;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("mode", mode);

    return map;
  }
}
