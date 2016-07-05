package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.response.GoodsResponse;

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

  @Override
  public boolean equals(Object o) {
    if (o instanceof Goods) {
      String goodsId = ((Goods) o).getGoodsId();

      return goodsId != null && goodsId.equals(getGoodsId());
    }

    return super.equals(o);
  }

  public Goods() {

  }

  public Goods(GoodsResponse response) {
    update(response);
  }

  public static ArrayList<Goods> createGoods(List<GoodsResponse> responses) {
    ArrayList<Goods> goodsList = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return goodsList;
    }

    for (GoodsResponse goodsResponse : responses) {
      goodsList.add(new Goods(goodsResponse));
    }

    return goodsList;
  }

  public void update(GoodsResponse response) {
    if (response == null) {
      return;
    }

    this.goodsId = valueOrDefault(response.goodsId, goodsId);
    this.name = response.name;
    this.description = response.description;
    this.quantity = response.quantity;
    this.amount = response.amount;
    this.imageUrl = response.imageUrl;
    this.tags = response.tags;
    this.code = response.code;
    this.group = response.group;
    this.startDate = response.startDate;
    this.expireDate = response.expireDate;
    this.isGroup = response.isGroup;
    this.sponsor = response.sponsor;
    this.sortOrder = response.sortOrder;
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

  public int getAmount() {
    return amount;
  }
}
