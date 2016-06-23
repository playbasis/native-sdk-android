package com.playbasis.pbcore.rest.form;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class CancelQuestForm extends PBForm {

  private String questId;
  private String playerId;

  public CancelQuestForm(String questId, String playerId) {
    this.questId = questId;
    this.playerId = playerId;
  }

  public String getQuestId() {
    return questId;
  }

  public String getPlayerId() {
    return playerId;
  }
}
