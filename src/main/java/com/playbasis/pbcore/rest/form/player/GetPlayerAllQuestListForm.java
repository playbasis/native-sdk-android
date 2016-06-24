package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.PBForm;

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

  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public String getFilter() {
    return filter;
  }

  public void setFilter(String filter) {
    this.filter = filter;
  }
}
