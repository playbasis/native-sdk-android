package com.playbasis.pbcore.rest.response;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Tar on 9/20/16 AD.
 */
public class RecentActivityResponse {

  public String id;
  public String actionIcon;
  public String actionName;
  public Date dateAdded;
  public String eventType;
  public String stringFilter;
  public PlayerResponse player;
  public RecentActivityDataInterface data;

  public interface RecentActivityDataInterface {

  }

  public class ActionResponse implements RecentActivityDataInterface {

    @SerializedName("url")
    public String url;

  }

  public abstract class BaseRewardResponse implements RecentActivityDataInterface {

    @SerializedName("reward_id")
    public String id;
    @SerializedName("reward_name")
    public String name;
    @SerializedName("value")
    public int value;
    @SerializedName("goods_id")
    public String goodsId;
    @SerializedName("quest_id")
    public String questId;
    @SerializedName("mission_id")
    public String missionid;
    @SerializedName("quiz_id")
    public String quizId;

  }

  public class RewardResponse extends BaseRewardResponse {

  }

  public class RedeemResponse extends BaseRewardResponse {

    @SerializedName("action_log_id")
    public String actionLogId;
    @SerializedName("goods")
    public GoodsResponse goodsResponse;

  }
}
