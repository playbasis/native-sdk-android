package com.playbasis.pbcore.rest.form.quest;

import com.playbasis.pbcore.rest.form.PBForm;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class QuestLeaderboardForm extends PBForm {

  private String questId;

  public QuestLeaderboardForm(String questId) {
    this.questId = questId;
  }

  public String getQuestId() {
    return questId;
  }
}
