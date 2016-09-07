package com.playbasis.pbcore.rest.form.quest;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class QuestLeaderboardForm extends PBForm {

  private String questId;
  private String completionElementId = null;
  private int offset = 0;
  private int limit = 20;
  private String status = null;
  private String playerId = null;

  public QuestLeaderboardForm(String questId) {
    this.questId = questId;
  }

  public String getQuestId() {
    return questId;
  }

  public void setCompletionElementId(String completionElementId) {
    this.completionElementId = completionElementId;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setPlayerId(String playerId) {
    this.playerId = playerId;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("completion_element_id", completionElementId);
    map.put("player_id", playerId);
    map.put("offset", offset);
    map.put("limit", limit);
    map.put("status", status);

    return map;
  }
}
