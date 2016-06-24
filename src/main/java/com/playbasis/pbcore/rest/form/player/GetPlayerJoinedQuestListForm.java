package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.PBForm;

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

  public GetPlayerJoinedQuestListForm(String playerId, String filter, String tags) {
    this.playerId = playerId;
    this.filter = filter;
    this.tags = tags;
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

  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }
}
