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

  private void setup(BaseQuestResponse baseQuestResponse) {
    this.questId = baseQuestResponse.questId;
    this.name = baseQuestResponse.name;
    this.description = baseQuestResponse.description;
    this.hint = baseQuestResponse.hint;
    this.imageUrl = baseQuestResponse.imageUrl;
    this.status = baseQuestResponse.status;
    this.tags = baseQuestResponse.tags;
    this.sortOrder = baseQuestResponse.sortOrder;
    this.missionOrder = baseQuestResponse.missionOrder;
    this.addedDate = baseQuestResponse.addedDate;
    this.clientId = baseQuestResponse.clientId;
    this.siteId = baseQuestResponse.siteId;
    this.feedbacks = baseQuestResponse.feedbacks;
    this.organizeId = baseQuestResponse.organizeId;
    this.organizeRole = baseQuestResponse.organizeRole;
    this.modifiedDate = baseQuestResponse.modifiedDate;
    this.missions = Mission.create(baseQuestResponse.missionResponses);
    this.conditions = Condition.create(baseQuestResponse.conditionResponses);
    this.rewards = Reward.create(baseQuestResponse.rewardResponses);
  }

  public void init(QuestResponse questResponse) {
    setup(questResponse);
  }

  public void init(PlayerQuestResponse playerQuestResponse) {
    setup(playerQuestResponse);

    if (playerQuestResponse.numMissionsResponse != null) {
      this.numMissions = new NumMissions(playerQuestResponse.numMissionsResponse);
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
