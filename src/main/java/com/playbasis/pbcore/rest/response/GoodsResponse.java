package com.playbasis.pbcore.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tar on 6/21/16 AD.
 */
public class GoodsResponse implements RewardResponse.RewardDataInterface {

  @Expose
  @SerializedName("goods_id")
  public String goodsId;
  @Expose
  @SerializedName("name")
  public String name;
  @Expose
  @SerializedName("description")
  public String description;
  @Expose
  @SerializedName("quantity")
  public int quantity;
  @Expose
  @SerializedName("amount")
  public int amount;
  @Expose
  @SerializedName("image")
  public String imageUrl;
  @Expose
  @SerializedName("tags")
  public List<String> tags;
  @Expose
  @SerializedName("group")
  public String group;
  @Expose
  @SerializedName("date_start")
  public Date startDate;
  @Expose
  @SerializedName("date_expire")
  public Date expireDate;
  @Expose
  @SerializedName("is_group")
  public boolean isGroup;
  @Expose
  @SerializedName("sponsor")
  public boolean sponsor;
  @Expose
  @SerializedName("sort_order")
  public int sortOrder;
  @Expose
  @SerializedName("code")
  public CodeResponse codeResponse;
  @SerializedName("redeem")
  public RedeemConditionResponse redeemConditionResponse;

  public ArrayList<String> getCodes() {
    if (codeResponse != null) {
      return codeResponse.codes;
    }

    return null;
  }

  public RedeemConditionResponse getRedeemConditionResponse() {
    return redeemConditionResponse;
  }

  public static class CodeResponse {

    public ArrayList<String> codes;

  }

  public static class RedeemConditionResponse {

    @SerializedName("point")
    public PointCondition pointCondition;
    @SerializedName("custom")
    public ArrayList<CustomCondition> customConditionResponses;

    public static class CustomCondition {
      @SerializedName("custom_id")
      public String customId;
      @SerializedName("custom_name")
      public String customName;
      @SerializedName("custom_value")
      public int customValue;
    }

    public static class PointCondition {
      @SerializedName("point_value")
      public int value;
    }
  }

}
