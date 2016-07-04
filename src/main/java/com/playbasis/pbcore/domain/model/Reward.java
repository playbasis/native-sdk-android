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

  public Reward(RewardResponse response) {
    update(response);
  }

  public static ArrayList<Reward> create(List<RewardResponse> responses) {
    ArrayList<Reward> rewards = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return rewards;
    }

    for (RewardResponse rewardResponse : responses) {
      Reward reward = new Reward();
      reward.update(rewardResponse);
      rewards.add(reward);
    }

    return rewards;
  }

  public void update(RewardResponse response) {
    if (response == null) {
      return;
    }

    this.rewardId = valueOrDefault(response.rewardId, rewardId);
    this.type = response.type;
    this.value = response.value;

    if (response.data instanceof RewardResponse.RewardGoodsResponse) {
      this.redeemable = new Goods((RewardResponse.RewardGoodsResponse) response.data);
    } else if (response.data instanceof RewardResponse.RewardBadgeResponse) {
      this.redeemable = new Badge((RewardResponse.RewardBadgeResponse) response.data);
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

    String getName();
    String getDescription();
    String getImageUrl();
  }

  public class Goods extends com.playbasis.pbcore.domain.model.Goods implements Redeemable {

    protected Date addedDate;
    protected Date modifiedDate;
    protected int perUser;
    protected boolean status;
    protected boolean deleted;

    private Goods(RewardResponse.RewardGoodsResponse rewardGoodsResponse) {
      if (rewardGoodsResponse == null) {
        return;
      }

      this.addedDate = rewardGoodsResponse.addedDate;
      this.modifiedDate = rewardGoodsResponse.modifiedDate;
      this.perUser = rewardGoodsResponse.perUser;
      this.status = rewardGoodsResponse.status;
      this.deleted = rewardGoodsResponse.deleted;

      update(rewardGoodsResponse);
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

    public Badge(RewardResponse.RewardBadgeResponse rewardBadgeResponse) {
      if (rewardBadgeResponse == null) {
        return;
      }

      this.claim = rewardBadgeResponse.claim;
      this.redeem = rewardBadgeResponse.redeem;

      update(rewardBadgeResponse);
    }
  }
}
