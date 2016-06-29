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
  protected Redeemable redeemable;

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

    if (response.data instanceof RewardResponse.RewardGoodsResponse) {
      this.redeemable = valueOrDefault(new Goods((RewardResponse.RewardGoodsResponse) response.data, allowNull), this.redeemable, allowNull);
    } else if (response.data instanceof RewardResponse.RewardBadgeResponse) {
      this.redeemable = valueOrDefault(new Badge((RewardResponse.RewardBadgeResponse) response.data, allowNull), this.redeemable, allowNull);
    } else if (allowNull) {
      this.redeemable = null;
    }
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

  public Redeemable getRedeemable() {
    return redeemable;
  }

  public interface Redeemable {

  }

  public class Goods extends com.playbasis.pbcore.domain.model.Goods implements Redeemable {

    protected Date addedDate;
    protected Date modifiedDate;
    protected int perUser;
    protected boolean status;
    protected boolean deleted;

    private Goods(RewardResponse.RewardGoodsResponse rewardGoodsResponse, boolean allowNull) {
      if (rewardGoodsResponse == null) {
        return;
      }

      this.addedDate = valueOrDefault(rewardGoodsResponse.addedDate, addedDate, allowNull);
      this.modifiedDate = valueOrDefault(rewardGoodsResponse.modifiedDate, modifiedDate, allowNull);
      this.perUser = valueOrDefault(rewardGoodsResponse.perUser, perUser, allowNull);
      this.status = valueOrDefault(rewardGoodsResponse.status, status, allowNull);
      this.deleted = valueOrDefault(rewardGoodsResponse.deleted, deleted, allowNull);

      init(rewardGoodsResponse, allowNull);
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

  public class Badge extends com.playbasis.pbcore.domain.model.Badge implements Redeemable {
    protected boolean claim;
    protected boolean redeem;

    public Badge(RewardResponse.RewardBadgeResponse rewardBadgeResponse, boolean allowNull) {
      if (rewardBadgeResponse == null) {
        return;
      }

      this.claim = valueOrDefault(rewardBadgeResponse.claim, claim, allowNull);
      this.redeem = valueOrDefault(rewardBadgeResponse.redeem, redeem, allowNull);

      init(rewardBadgeResponse, allowNull);
    }
  }
}
