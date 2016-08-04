package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetPlayerAllQuestListForm extends PBForm {

  private String playerId;
  private String tags;
  private String filter;

  public GetPlayerAllQuestListForm(String playerId) {
    this.playerId = playerId;
  }

  public GetPlayerAllQuestListForm(String playerId, String tags, String filter) {
    this.playerId = playerId;
    this.tags = tags;
    this.filter = filter;
  }

  public String getPlayerId() {
    return playerId;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public void setFilter(String filter) {
    this.filter = filter;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("tags", tags);
    map.put("filter", filter);

    return map;
  }
}
