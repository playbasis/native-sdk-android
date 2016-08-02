package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.PBForm;

/**
 * Created by Tar on 6/10/16 AD.
 */
public class GetPlayerRankingForm extends PBForm {

  protected String rankBy;
  protected String limit;

  public GetPlayerRankingForm(String rankBy) {
    this.rankBy = rankBy;
    this.limit = "100";
  }

  public GetPlayerRankingForm(String rankBy, String limit) {
    this.rankBy = rankBy;
    this.limit = limit;
  }

  public String getRankBy() {
    return rankBy;
  }

  public String getLimit() {
    return limit;
  }
}
