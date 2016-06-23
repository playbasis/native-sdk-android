package com.playbasis.pbcore.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by Tar on 5/5/16 AD.
 */
public class BaseQuestResponse<T extends BaseMissionResponse> {

  @Expose
  @SerializedName("quest_id")
  public String questId;
  @Expose
  @SerializedName("quest_name")
  public String name;
  @Expose
  @SerializedName("description")
  public String description;
  @Expose
  @SerializedName("hint")
  public String hint;
  @Expose
  @SerializedName("image")
  public String imageUrl;
  @Expose
  @SerializedName("sort_order")
  public String sortOrder;
  @Expose
  @SerializedName("client_id")
  public String clientId;
  @Expose
  @SerializedName("site_id")
  public String siteId;
  @Expose
  @SerializedName("feedbacks")
  public String feedbacks;
  @Expose
  @SerializedName("organize_id")
  public String organizeId;
  @Expose
  @SerializedName("organize_role")
  public String organizeRole;
  @Expose
  @SerializedName("date_added")
  public Date addedDate;
  @Expose
  @SerializedName("date_modified")
  public Date modifiedDate;
  @Expose
  @SerializedName("tags")
  public List<String> tags;
  @Expose
  @SerializedName("status")
  public boolean status;
  @Expose
  @SerializedName("mission_order")
  public boolean missionOrder;
  @Expose
  @SerializedName("missions")
  public List<T> missionResponses;
  @Expose
  @SerializedName("condition")
  public List<ConditionResponse> conditionResponses;
  @Expose
  @SerializedName("rewards")
  public List<RewardResponse> rewardResponses;

  public static class ConditionResponse {
    @Expose
    @SerializedName("condition_id")
    public String conditionId;
    @Expose
    @SerializedName("condition_value")
    public String value;
    @Expose
    @SerializedName("condition_type")
    public String type;
  }

}
