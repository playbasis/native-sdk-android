package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.result.response.GoodsResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tar on 6/21/16 AD.
 */
public class Goods extends PBModel {

  protected String goodsId;
  protected String name;
  protected String description;
  protected String imageUrl;
  protected String code;
  protected String group;
  protected List<String> tags;
  protected Date startDate;
  protected Date expireDate;
  protected int quantity;
  protected int amount;
  protected int sortOrder;
  protected boolean isGroup;
  protected boolean sponsor;

  public Goods() {

  }

  public static ArrayList<Goods> create(List<GoodsResponse> responses) {
    ArrayList<Goods> goodsList = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return goodsList;
    }

    for (GoodsResponse goodsResponse : responses) {
      Goods goods = new Goods();
      goods.init(goodsResponse);
      goodsList.add(goods);
    }

    return goodsList;
  }

  public void init(GoodsResponse goodsResponse) {
    this.goodsId = goodsResponse.goodsId;
    this.name = goodsResponse.name;
    this.description = goodsResponse.description;
    this.quantity = goodsResponse.quantity;
    this.amount = goodsResponse.amount;
    this.imageUrl = goodsResponse.imageUrl;
    this.tags = goodsResponse.tags;
    this.code = goodsResponse.code;
    this.group = goodsResponse.group;
    this.startDate = goodsResponse.startDate;
    this.expireDate = goodsResponse.expireDate;
    this.isGroup = goodsResponse.isGroup;
    this.sponsor = goodsResponse.sponsor;
    this.sortOrder = goodsResponse.sortOrder;
  }

  public String getGoodsId() {
    return goodsId;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public int getQuantity() {
    return quantity;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public String getCode() {
    return code;
  }

  public List<String> getTags() {
    return tags;
  }

  public String getGroup() {
    return group;
  }

  public Date getStartDate() {
    return startDate;
  }

  public Date getExpireDate() {
    return expireDate;
  }

  public boolean isGroup() {
    return isGroup;
  }

  public boolean isSponsor() {
    return sponsor;
  }

  public int getSortOrder() {
    return sortOrder;
  }
}
