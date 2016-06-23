package com.playbasis.pbcore.rest.form.quest;

import com.playbasis.pbcore.rest.form.PBForm;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetMissionInfoForm extends PBForm {

  private String missionId;
  private String questId;

  public GetMissionInfoForm(String questId, String missionId) {
    this.questId = questId;
    this.missionId = missionId;
  }

  public String getQuestId() {
    return questId;
  }

  public String getMissionId() {
    return missionId;
  }
}
