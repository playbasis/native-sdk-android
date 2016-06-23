package com.playbasis.pbcore.rest.form.quest;

import com.playbasis.pbcore.rest.form.PBForm;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetQuestInfoForm extends PBForm {

  private String questId;

  public GetQuestInfoForm(String questId) {
    this.questId = questId;
  }

  public String getQuestId() {
    return questId;
  }
}
