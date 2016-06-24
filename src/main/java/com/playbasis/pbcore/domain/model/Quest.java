package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.response.BaseQuestResponse;
import com.playbasis.pbcore.rest.response.PlayerQuestResponse;
import com.playbasis.pbcore.rest.response.QuestResponse;

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
  protected NumMissions numMissions;

  public Quest() {

  }

  public static <T extends BaseQuestResponse> ArrayList<Quest> create(List<T> responses) {
    ArrayList<Quest> quests = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return quests;
    }

    for (int i = 0; i < responses.size(); i++) {
      T response = responses.get(i);
      Quest quest = new Quest();

      if (response instanceof QuestResponse) {
        quest.init((QuestResponse) response);
      } else if (response instanceof PlayerQuestResponse) {
        quest.init((PlayerQuestResponse) response);
      }

      quests.add(quest);
    }

    return quests;
  }

  private void setup(BaseQuestResponse response, boolean allowNull) {
    this.questId = valueOrDefault(response.questId, this.questId);
    this.name = valueOrDefault(response.name, this.name, allowNull);
    this.description = valueOrDefault(response.description, this.description, allowNull);
    this.hint = valueOrDefault(response.hint, this.hint, allowNull);
    this.imageUrl = valueOrDefault(response.imageUrl, this.imageUrl, allowNull);
    this.status = valueOrDefault(response.status, this.status, allowNull);
    this.tags = valueOrDefault(response.tags, this.tags, allowNull);
    this.sortOrder = valueOrDefault(response.sortOrder, this.sortOrder, allowNull);
    this.missionOrder = valueOrDefault(response.missionOrder, this.missionOrder, allowNull);
    this.addedDate = valueOrDefault(response.addedDate, this.addedDate, allowNull);
    this.clientId = valueOrDefault(response.clientId, this.clientId, allowNull);
    this.siteId = valueOrDefault(response.siteId, this.siteId, allowNull);
    this.feedbacks = valueOrDefault(response.feedbacks, this.feedbacks, allowNull);
    this.organizeId = valueOrDefault(response.organizeId, this.organizeId, allowNull);
    this.organizeRole = valueOrDefault(response.organizeRole, this.organizeRole, allowNull);
    this.modifiedDate = valueOrDefault(response.modifiedDate, this.modifiedDate, allowNull);
    this.missions = valueOrDefault(Mission.create(response.missionResponses), this.missions, allowNull);
    this.conditions = valueOrDefault(Condition.create(response.conditionResponses), this.conditions, allowNull);
    this.rewards = valueOrDefault(Reward.create(response.rewardResponses), this.rewards, allowNull);
  }

  public void init(QuestResponse response) {
    init(response, true);
  }

  public void init(QuestResponse response, boolean allowNull) {
    setup(response, allowNull);
  }

  public void init(PlayerQuestResponse response) {
    init(response, true);
  }

  public void init(PlayerQuestResponse response, boolean allowNull) {
    setup(response, allowNull);

    if (response.numMissionsResponse != null) {
      this.numMissions = valueOrDefault(new NumMissions(response.numMissionsResponse), this.numMissions, allowNull);
    }
  }

  public static class Condition {

    protected String conditionId;
    protected String value;
    protected String type;

    public Condition() {
    }

    public static ArrayList<Condition> create(List<BaseQuestResponse.ConditionResponse> responses) {
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
