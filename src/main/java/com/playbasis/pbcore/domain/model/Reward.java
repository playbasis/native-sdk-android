package com.playbasis.pbcore.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

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
    this.type = response.rewardType;
    this.value = response.rewardValue;

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

  public interface Redeemable extends Parcelable {

    String getName();
    String getDescription();
    String getImageUrl();
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.rewardId);
    dest.writeString(this.type);
    dest.writeString(this.value);
    dest.writeParcelable(this.redeemable, flags);
  }

  protected Reward(Parcel in) {
    this.rewardId = in.readString();
    this.type = in.readString();
    this.value = in.readString();
    this.redeemable = in.readParcelable(Redeemable.class.getClassLoader());
  }

  public static final Creator<Reward> CREATOR = new Creator<Reward>() {
    @Override
    public Reward createFromParcel(Parcel source) {
      return new Reward(source);
    }

    @Override
    public Reward[] newArray(int size) {
      return new Reward[size];
    }
  };

  public static class Goods extends com.playbasis.pbcore.domain.model.Goods implements Redeemable {

    protected Date addedDate;
    protected Date modifiedDate;
    protected int perUser;
    protected boolean deleted;

    public Goods() {

    }

    public Goods(RewardResponse.RewardGoodsResponse rewardGoodsResponse) {
      if (rewardGoodsResponse == null) {
        return;
      }

      this.addedDate = rewardGoodsResponse.addedDate;
      this.modifiedDate = rewardGoodsResponse.modifiedDate;
      this.perUser = rewardGoodsResponse.perUser;
      this.deleted = rewardGoodsResponse.deleted;

      update(rewardGoodsResponse);
    }

    public Date getAddedDate() {
      return addedDate;
    }

    public Date getModifiedDate() {
      return modifiedDate;
    }

    public int getPerUser() {
      return perUser;
    }

    public boolean isDeleted() {
      return deleted;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      super.writeToParcel(dest, flags);
      dest.writeLong(this.addedDate != null ? this.addedDate.getTime() : -1);
      dest.writeLong(this.modifiedDate != null ? this.modifiedDate.getTime() : -1);
      dest.writeInt(this.perUser);
      dest.writeByte(this.deleted ? (byte) 1 : (byte) 0);
      dest.writeString(this.goodsId);
      dest.writeString(this.name);
      dest.writeString(this.description);
      dest.writeString(this.imageUrl);
      dest.writeString(this.group);
      dest.writeStringList(this.codes);
      dest.writeStringList(this.tags);
      dest.writeLong(this.startDate != null ? this.startDate.getTime() : -1);
      dest.writeLong(this.expireDate != null ? this.expireDate.getTime() : -1);
      dest.writeInt(this.quantity);
      dest.writeInt(this.amount);
      dest.writeInt(this.sortOrder);
      dest.writeByte(this.isGroup ? (byte) 1 : (byte) 0);
      dest.writeByte(this.sponsor ? (byte) 1 : (byte) 0);
      dest.writeParcelable(this.redeemCondition, flags);
    }

    protected Goods(Parcel in) {
      super(in);
      long tmpAddedDate = in.readLong();
      this.addedDate = tmpAddedDate == -1 ? null : new Date(tmpAddedDate);
      long tmpModifiedDate = in.readLong();
      this.modifiedDate = tmpModifiedDate == -1 ? null : new Date(tmpModifiedDate);
      this.perUser = in.readInt();
      this.deleted = in.readByte() != 0;
      this.goodsId = in.readString();
      this.name = in.readString();
      this.description = in.readString();
      this.imageUrl = in.readString();
      this.group = in.readString();
      this.codes = in.createStringArrayList();
      this.tags = in.createStringArrayList();
      long tmpStartDate = in.readLong();
      this.startDate = tmpStartDate == -1 ? null : new Date(tmpStartDate);
      long tmpExpireDate = in.readLong();
      this.expireDate = tmpExpireDate == -1 ? null : new Date(tmpExpireDate);
      this.quantity = in.readInt();
      this.amount = in.readInt();
      this.sortOrder = in.readInt();
      this.isGroup = in.readByte() != 0;
      this.sponsor = in.readByte() != 0;
      this.redeemCondition = in.readParcelable(RedeemCondition.class.getClassLoader());
    }

    public static final Creator<Goods> CREATOR = new Creator<Goods>() {
      @Override
      public Goods createFromParcel(Parcel source) {
        return new Goods(source);
      }

      @Override
      public Goods[] newArray(int size) {
        return new Goods[size];
      }
    };
  }

  public static class Badge extends com.playbasis.pbcore.domain.model.Badge implements Redeemable {

    protected boolean claim;
    protected boolean redeem;

    public Badge() {

    }

    public Badge(RewardResponse.RewardBadgeResponse rewardBadgeResponse) {
      if (rewardBadgeResponse == null) {
        return;
      }

      this.claim = rewardBadgeResponse.claim;
      this.redeem = rewardBadgeResponse.redeem;

      update(rewardBadgeResponse);
    }

    public boolean isClaim() {
      return claim;
    }

    public boolean isRedeem() {
      return redeem;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      super.writeToParcel(dest, flags);
      dest.writeByte(this.claim ? (byte) 1 : (byte) 0);
      dest.writeByte(this.redeem ? (byte) 1 : (byte) 0);
      dest.writeString(this.badgeId);
      dest.writeString(this.imageUrl);
      dest.writeString(this.name);
      dest.writeString(this.description);
      dest.writeString(this.hint);
      dest.writeByte(this.sponsor ? (byte) 1 : (byte) 0);
      dest.writeInt(this.amount);
      dest.writeInt(this.sortOrder);
    }

    protected Badge(Parcel in) {
      super(in);
      this.claim = in.readByte() != 0;
      this.redeem = in.readByte() != 0;
      this.badgeId = in.readString();
      this.imageUrl = in.readString();
      this.name = in.readString();
      this.description = in.readString();
      this.hint = in.readString();
      this.sponsor = in.readByte() != 0;
      this.amount = in.readInt();
      this.sortOrder = in.readInt();
    }

    public static final Creator<Badge> CREATOR = new Creator<Badge>() {
      @Override
      public Badge createFromParcel(Parcel source) {
        return new Badge(source);
      }

      @Override
      public Badge[] newArray(int size) {
        return new Badge[size];
      }
    };
  }
}
