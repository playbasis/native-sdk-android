package com.playbasis.pbcore.rest.result.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Tar on 5/5/16 AD.
 */
public class QuestResponse {

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
  @SerializedName("status")
  public String status;
  @Expose
  @SerializedName("tags")
  public String tags;
  @Expose
  @SerializedName("sort_order")
  public String sortOrder;
  @Expose
  @SerializedName("mission_order")
  public String missionOrder;
  @Expose
  @SerializedName("date_added")
  public String addedDate;
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
  @SerializedName("date_modified")
  public String modifiedDate;
  @Expose
  @SerializedName("missions")
  public List<MissionResponse> missionResponses;
  @Expose
  @SerializedName("condition")
  public List<ConditionResponse> conditionResponses;
  @Expose
  @SerializedName("rewards")
  public List<RewardResponse> rewardResponses;

  public class ConditionResponse {
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
