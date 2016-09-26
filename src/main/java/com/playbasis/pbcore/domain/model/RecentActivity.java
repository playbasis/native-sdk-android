package com.playbasis.pbcore.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.playbasis.pbcore.rest.response.RecentActivityResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tar on 9/20/16 AD.
 */
public class RecentActivity extends PBModel {

  protected String recentActivityId;
  protected String actionIcon;
  protected String actionName;
  protected Date dateAdded;
  protected String eventType;
  protected String stringFilter;
  protected Player player;
  protected Eventable eventable;

  public RecentActivity() {

  }

  public RecentActivity(RecentActivityResponse response) {
    update(response);
  }

  public static ArrayList<RecentActivity> createRecentActivities(List<RecentActivityResponse> responses) {
    ArrayList<RecentActivity> recentActivities = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return recentActivities;
    }

    for (RecentActivityResponse response : responses) {
      recentActivities.add(new RecentActivity(response));
    }

    return recentActivities;
  }

  public void update(RecentActivityResponse response) {
    this.recentActivityId = valueOrDefault(response.id, recentActivityId);
    this.actionIcon = response.actionIcon;
    this.actionName = response.actionName;
    this.dateAdded = response.dateAdded;
    this.eventType = response.eventType;
    this.stringFilter = response.stringFilter;
    this.player = new Player(response.playerResponse);

    if (response.data instanceof RecentActivityResponse.ActionResponse) {
      this.eventable = new Action((RecentActivityResponse.ActionResponse) response.data);
    } else if (response.data instanceof RecentActivityResponse.RedeemResponse) {
      this.eventable = new Redeem((RecentActivityResponse.RedeemResponse) response.data);
    } else if (response.data instanceof RecentActivityResponse.RewardResponse) {
      this.eventable = new Reward((RecentActivityResponse.RewardResponse) response.data);
    } else if (response.data instanceof RecentActivityResponse.LevelResponse) {
      this.eventable = new Level((RecentActivityResponse.LevelResponse) response.data);
    }
  }

  public String getRecentActivityId() {
    return recentActivityId;
  }

  public String getActionIcon() {
    return actionIcon;
  }

  public String getActionName() {
    return actionName;
  }

  public Date getDateAdded() {
    return dateAdded;
  }

  public String getEventType() {
    return eventType;
  }

  public String getStringFilter() {
    return stringFilter;
  }

  public Player getPlayer() {
    return player;
  }

  public Eventable getEventable() {
    return eventable;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.recentActivityId);
    dest.writeString(this.actionIcon);
    dest.writeString(this.actionName);
    dest.writeLong(this.dateAdded != null ? this.dateAdded.getTime() : -1);
    dest.writeString(this.eventType);
    dest.writeString(this.stringFilter);
    dest.writeParcelable(this.player, flags);
    dest.writeParcelable(this.eventable, flags);
  }

  protected RecentActivity(Parcel in) {
    this.recentActivityId = in.readString();
    this.actionIcon = in.readString();
    this.actionName = in.readString();
    long tmpDateAdded = in.readLong();
    this.dateAdded = tmpDateAdded == -1 ? null : new Date(tmpDateAdded);
    this.eventType = in.readString();
    this.stringFilter = in.readString();
    this.player = in.readParcelable(Player.class.getClassLoader());
    this.eventable = in.readParcelable(Eventable.class.getClassLoader());
  }

  public static final Creator<RecentActivity> CREATOR = new Creator<RecentActivity>() {
    @Override
    public RecentActivity createFromParcel(Parcel source) {
      return new RecentActivity(source);
    }

    @Override
    public RecentActivity[] newArray(int size) {
      return new RecentActivity[size];
    }
  };

  public interface Eventable extends Parcelable {

  }

  public static class Action extends PBModel implements Eventable {

    protected String url;
    protected Player secondPlayer;

    public Action(RecentActivityResponse.ActionResponse response) {
      this.url = response.url;

      if (response.secondPlayerResponse != null) {
        this.secondPlayer = new Player(response.secondPlayerResponse);
      }
    }

    public String getUrl() {
      return url;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.url);
      dest.writeParcelable(this.secondPlayer, flags);
    }

    protected Action(Parcel in) {
      this.url = in.readString();
      this.secondPlayer = in.readParcelable(Player.class.getClassLoader());
    }

    public static final Creator<Action> CREATOR = new Creator<Action>() {
      @Override
      public Action createFromParcel(Parcel source) {
        return new Action(source);
      }

      @Override
      public Action[] newArray(int size) {
        return new Action[size];
      }
    };
  }

  public static abstract class BaseReward extends PBModel implements Eventable {

    public String rewardId;
    public int value;
    public String name;
    public String goodsId;
    public String questId;
    public String missionid;
    public String quizId;
    public String message;

    public BaseReward() {

    }

    public BaseReward(RecentActivityResponse.BaseRewardResponse rewardResponse) {
      this.rewardId = rewardResponse.id;
      this.name = rewardResponse.name;
      this.value = rewardResponse.value;
      this.name = rewardResponse.name;
      this.goodsId = rewardResponse.goodsId;
      this.questId = rewardResponse.questId;
      this.missionid = rewardResponse.questId;
      this.quizId = rewardResponse.quizId;
      this.message = rewardResponse.message;
    }

    public String getRewardId() {
      return rewardId;
    }

    public int getValue() {
      return value;
    }

    public String getName() {
      return name;
    }

    public String getGoodsId() {
      return goodsId;
    }

    public String getQuestId() {
      return questId;
    }

    public String getMissionid() {
      return missionid;
    }

    public String getQuizId() {
      return quizId;
    }

    public String getMessage() {
      return message;
    }
  }

  public static class Reward extends BaseReward {

    public Reward(RecentActivityResponse.RewardResponse rewardResponse) {
      super(rewardResponse);
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.rewardId);
      dest.writeInt(this.value);
      dest.writeString(this.name);
      dest.writeString(this.goodsId);
      dest.writeString(this.questId);
      dest.writeString(this.missionid);
      dest.writeString(this.quizId);
      dest.writeString(this.message);
    }

    protected Reward(Parcel in) {
      this.rewardId = in.readString();
      this.value = in.readInt();
      this.name = in.readString();
      this.goodsId = in.readString();
      this.questId = in.readString();
      this.missionid = in.readString();
      this.quizId = in.readString();
      this.message = in.readString();
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
  }

  public static class Redeem extends BaseReward {

    protected String actionLogId;
    protected Goods goods;

    public Redeem(RecentActivityResponse.RedeemResponse rewardResponse) {
      super(rewardResponse);

      this.actionLogId = rewardResponse.actionLogId;
      this.goods = new Goods(rewardResponse.goodsResponse);
    }

    public String getActionLogId() {
      return actionLogId;
    }

    public Goods getGoods() {
      return goods;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.actionLogId);
      dest.writeParcelable(this.goods, flags);
      dest.writeString(this.rewardId);
      dest.writeInt(this.value);
      dest.writeString(this.name);
      dest.writeString(this.goodsId);
      dest.writeString(this.questId);
      dest.writeString(this.missionid);
      dest.writeString(this.quizId);
      dest.writeString(this.message);
    }

    protected Redeem(Parcel in) {
      this.actionLogId = in.readString();
      this.goods = in.readParcelable(Goods.class.getClassLoader());
      this.rewardId = in.readString();
      this.value = in.readInt();
      this.name = in.readString();
      this.goodsId = in.readString();
      this.questId = in.readString();
      this.missionid = in.readString();
      this.quizId = in.readString();
      this.message = in.readString();
    }

    public static final Creator<Redeem> CREATOR = new Creator<Redeem>() {
      @Override
      public Redeem createFromParcel(Parcel source) {
        return new Redeem(source);
      }

      @Override
      public Redeem[] newArray(int size) {
        return new Redeem[size];
      }
    };
  }

  public static class Level extends BaseReward {

    public Level(RecentActivityResponse.BaseRewardResponse rewardResponse) {
      super(rewardResponse);
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.rewardId);
      dest.writeInt(this.value);
      dest.writeString(this.name);
      dest.writeString(this.goodsId);
      dest.writeString(this.questId);
      dest.writeString(this.missionid);
      dest.writeString(this.quizId);
      dest.writeString(this.message);
    }

    protected Level(Parcel in) {
      this.rewardId = in.readString();
      this.value = in.readInt();
      this.name = in.readString();
      this.goodsId = in.readString();
      this.questId = in.readString();
      this.missionid = in.readString();
      this.quizId = in.readString();
      this.message = in.readString();
    }

    public static final Creator<Level> CREATOR = new Creator<Level>() {
      @Override
      public Level createFromParcel(Parcel source) {
        return new Level(source);
      }

      @Override
      public Level[] newArray(int size) {
        return new Level[size];
      }
    };
  }
}
