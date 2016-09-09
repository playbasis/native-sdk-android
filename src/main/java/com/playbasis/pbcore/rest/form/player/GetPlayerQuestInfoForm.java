package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetPlayerQuestInfoForm extends PBForm {

  private String questId;
  private String playerId;
  private String filter;

  public GetPlayerQuestInfoForm(String questId, String playerId) {
    this.questId = questId;
    this.playerId = playerId;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("filter", filter);

    return map;
  }

  public String getQuestId() {
    return questId;
  }

  public String getPlayerId() {
    return playerId;
  }

  public String getFilter() {
    return filter;
  }

  public void setFilter(String filter) {
    this.filter = filter;
  }
}
