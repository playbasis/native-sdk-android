package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.result.response.RewardResponse;

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

  public void init(RewardResponse rewardResponse) {
    if (rewardResponse == null) {
      return;
    }

    this.rewardId = rewardResponse.rewardId;
    this.type = rewardResponse.type;
    this.value = rewardResponse.value;
    this.data = new Data(rewardResponse.data);
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

    private Data(RewardResponse.DataResponse dataResponse) {
      if (dataResponse == null) {
        return;
      }

      this.addedDate = dataResponse.addedDate;
      this.modifiedDate = dataResponse.modifiedDate;
      this.perUser = dataResponse.perUser;
      this.status = dataResponse.status;
      this.deleted = dataResponse.deleted;

      init(dataResponse);
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
