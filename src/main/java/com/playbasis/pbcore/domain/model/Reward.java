package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.response.RewardResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tar on 6/22/16 AD.
 */
public class Reward extends PBModel {

  protected String rewardId;
  protected String type;
  protected String value;
  protected Data data;

  public Reward() {

  }

  public static ArrayList<Reward> create(List<RewardResponse> responses) {
    ArrayList<Reward> rewards = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return rewards;
    }

    for (RewardResponse rewardResponse : responses) {
      Reward reward = new Reward();
      reward.init(rewardResponse);
      rewards.add(reward);
    }

    return rewards;
  }

  public void init(RewardResponse response) {
    init(response, true);
  }

  public void init(RewardResponse response, boolean allowNull) {
    if (response == null) {
      return;
    }

    this.rewardId = valueOrDefault(response.rewardId, this.rewardId);
    this.type = valueOrDefault(response.type, this.type, allowNull);
    this.value = valueOrDefault(response.value, this.value, allowNull);
    this.data = valueOrDefault(new Data(response.data, allowNull), this.data, allowNull);
  }

  public String getRewardId() {
    return rewardId;
  }

  public String getType() {
    return type;
  }

  public String getValue() {
    return value;
  }

  public Data getData() {
    return data;
  }

  public class Data extends com.playbasis.pbcore.domain.model.Goods {

    protected Date addedDate;
    protected Date modifiedDate;
    protected int perUser;
    protected boolean status;
    protected boolean deleted;

    private Data(RewardResponse.DataResponse dataResponse, boolean allowNull) {
      if (dataResponse == null) {
        return;
      }

      this.addedDate = valueOrDefault(dataResponse.addedDate, addedDate, allowNull);
      this.modifiedDate = valueOrDefault(dataResponse.modifiedDate, modifiedDate, allowNull);
      this.perUser = valueOrDefault(dataResponse.perUser, perUser, allowNull);
      this.status = valueOrDefault(dataResponse.status, status, allowNull);
      this.deleted = valueOrDefault(dataResponse.deleted, deleted, allowNull);

      init(dataResponse, allowNull);
    }

    public int getPerUser() {
      return perUser;
    }

    public boolean isStatus() {
      return status;
    }

    public boolean isDeleted() {
      return deleted;
    }
  }
}
