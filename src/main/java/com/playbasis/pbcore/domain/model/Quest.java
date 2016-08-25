package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.response.BaseQuestResponse;
import com.playbasis.pbcore.rest.response.PlayerQuestResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tar on 6/22/16 AD.
 */
public class Quest extends PBModel {

  protected String questId;
  protected String name;
  protected String description;
  protected String hint;
  protected String imageUrl;
  protected String sortOrder;
  protected String clientId;
  protected String siteId;
  protected String feedbacks;
  protected String organizeId;
  protected String organizeRole;
  protected Date addedDate;
  protected Date modifiedDate;
  protected List<String> tags;
  protected boolean status;
  protected boolean missionOrder;
  protected ArrayList<Mission> missions;
  protected ArrayList<Condition> conditions;
  protected ArrayList<Reward> rewards;
  protected String playerStatus;
  protected NumMissions numMissions;

  @Override
  public boolean equals(Object o) {
    if (o instanceof Quest) {
      String questId = ((Quest) o).getQuestId();

      return questId != null && questId.equals(getQuestId());
    }

    return super.equals(o);
  }

  public Quest() {

  }

  public Quest(BaseQuestResponse response) {
    update(response);
  }

  public static <T extends BaseQuestResponse> ArrayList<Quest> createQuests(List<T> responses) {
    ArrayList<Quest> quests = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return quests;
    }

    for (T response : responses) {
      quests.add(new Quest(response));
    }

    return quests;
  }

  public void update(BaseQuestResponse response) {
    if (response == null) {
      return;
    }

    this.questId = valueOrDefault(response.questId, questId);
    this.name = response.name;
    this.description = response.description;
    this.hint = response.hint;
    this.imageUrl = response.imageUrl;
    this.status = response.status;
    this.tags = response.tags;
    this.sortOrder = response.sortOrder;
    this.missionOrder = response.missionOrder;
    this.addedDate = response.addedDate;
    this.clientId = response.clientId;
    this.siteId = response.siteId;
    this.feedbacks = response.feedbacks;
    this.organizeId = response.organizeId;
    this.organizeRole = response.organizeRole;
    this.modifiedDate = response.modifiedDate;
    this.missions = Mission.createMissions(response.missionResponses);
    this.conditions = Condition.createConditions(response.conditionResponses);
    this.rewards = Reward.create(response.rewardResponses);

    if (response instanceof PlayerQuestResponse) {
      PlayerQuestResponse playerQuestResponse = (PlayerQuestResponse) response;

      this.playerStatus = playerQuestResponse.playerStatus;

      if (playerQuestResponse.numMissionsResponse != null) {
        this.numMissions = new NumMissions(playerQuestResponse.numMissionsResponse);
      }
    }
  }

  public String getQuestId() {
    return questId;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getHint() {
    return hint;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public String getSortOrder() {
    return sortOrder;
  }

  public String getClientId() {
    return clientId;
  }

  public String getSiteId() {
    return siteId;
  }

  public String getFeedbacks() {
    return feedbacks;
  }

  public String getOrganizeId() {
    return organizeId;
  }

  public String getOrganizeRole() {
    return organizeRole;
  }

  public Date getAddedDate() {
    return addedDate;
  }

  public Date getModifiedDate() {
    return modifiedDate;
  }

  public List<String> getTags() {
    return tags;
  }

  public boolean isStatus() {
    return status;
  }

  public boolean isMissionOrder() {
    return missionOrder;
  }

  public ArrayList<Mission> getMissions() {
    return missions;
  }

  public ArrayList<Condition> getConditions() {
    return conditions;
  }

  public ArrayList<Reward> getRewards() {
    return rewards;
  }

  public String getPlayerStatus() {
    return playerStatus;
  }

  public NumMissions getNumMissions() {
    return numMissions;
  }

  public static class Condition {

    protected String conditionId;
    protected String value;
    protected String type;

    public Condition() {
    }

    public static ArrayList<Condition> createConditions(List<BaseQuestResponse.ConditionResponse> responses) {
      ArrayList<Condition> ondition = new ArrayList<>();

      if (responses == null || responses.size() == 0) {
        return ondition;
      }

      for (BaseQuestResponse.ConditionResponse conditionResponse : responses) {
        Condition reward = new Condition();
        reward.init(conditionResponse);
        ondition.add(reward);
      }

      return ondition;
    }

    public void init(BaseQuestResponse.ConditionResponse conditionResponse) {
      this.conditionId = conditionResponse.conditionId;
      this.value = conditionResponse.value;
      this.type = conditionResponse.type;
    }

    public String getConditionId() {
      return conditionId;
    }

    public String getValue() {
      return value;
    }

    public String getType() {
      return type;
    }
  }

  public static class NumMissions {

    protected int total;
    protected int join;
    protected int unjoin;
    protected int finish;

    public NumMissions(PlayerQuestResponse.NumMissionsResponse numMissionsResponse) {
      this.total = numMissionsResponse.total;
      this.join = numMissionsResponse.join;
      this.unjoin = numMissionsResponse.unjoin;
      this.finish = numMissionsResponse.finish;
    }

    public int getTotal() {
      return total;
    }

    public int getJoin() {
      return join;
    }

    public int getUnjoin() {
      return unjoin;
    }

    public int getFinish() {
      return finish;
    }
  }
}
