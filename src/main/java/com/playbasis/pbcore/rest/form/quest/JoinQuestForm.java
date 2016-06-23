package com.playbasis.pbcore.rest.form.quest;

import com.playbasis.pbcore.rest.form.PBForm;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class JoinQuestForm extends PBForm {

  private String questId;
  private String playerId;

  public JoinQuestForm(String questId, String playerId) {
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
