package com.playbasis.pbcore.rest.form;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetPlayerJoinedQuestListForm extends PBForm {

  private String playerId;
  private String filter;
  private String tag;

  public GetPlayerJoinedQuestListForm(String playerId) {
    this.playerId = playerId;
  }

  public GetPlayerJoinedQuestListForm(String playerId, String filter, String tag) {
    this.playerId = playerId;
    this.filter = filter;
    this.tag = tag;
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

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }
}
