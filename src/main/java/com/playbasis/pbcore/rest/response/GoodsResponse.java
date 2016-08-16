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

  public ArrayList<String> getCodes() {
    if (codeResponse != null) {
      return codeResponse.codes;
    }

    return null;
  }

  public static class CodeResponse {

    public ArrayList<String> codes;

  }
}
