package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetPlayerJoinedQuestListForm extends PBForm {

  private String playerId;
  private String filter;
  private String tags;

  public GetPlayerJoinedQuestListForm(String playerId) {
    this.playerId = playerId;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("tags", tags);
    map.put("filter", filter);

    return map;
  }

  public String getPlayerId() {
    return playerId;
  }

  public String getFilter() {
    return filter;
  }

  public String getTags() {
    return tags;
  }

  public void setFilter(String filter) {
    this.filter = filter;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }
}
