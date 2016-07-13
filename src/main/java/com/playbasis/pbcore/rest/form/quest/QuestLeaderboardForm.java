package com.playbasis.pbcore.rest.form.quest;

import com.playbasis.pbcore.rest.form.PBForm;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class QuestLeaderboardForm extends PBForm {

  private String questId;
  private String completionElementId;
  private int limit = 100;
  private int offset = 0;
  private String status;
  private String playerId;

  public QuestLeaderboardForm(String questId) {
    this.questId = questId;
  }

  public QuestLeaderboardForm(String questId, String completionElementId) {
    this.questId = questId;
    this.completionElementId = completionElementId;
  }

  public String getQuestId() {
    return questId;
  }

  public String getCompletionElementId() {
    return completionElementId;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public int getOffset() {
    return offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getPlayerId() {
    return playerId;
  }

  public void setPlayerId(String playerId) {
    this.playerId = playerId;
  }
}
