package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.response.BadgeResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tar on 6/20/16 AD.
 */
public class Badge extends PBModel {

  protected String badgeId;
  protected String imageUrl;
  protected String name;
  protected String description;
  protected String hint;
  protected boolean sponsor;
  protected int amount;
  protected int sortOrder;

  public Badge() {

  }

  public Badge(BadgeResponse response) {
    update(response);
  }

  public static ArrayList<Badge> create(List<BadgeResponse> responses) {
    ArrayList<Badge> badges = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return badges;
    }

    for (BadgeResponse badgeResponse : responses) {
      badges.add(new Badge(badgeResponse));
    }

    return badges;
  }

  public void update(BadgeResponse response) {
    if (response == null) {
      return;
    }

    this.badgeId = valueOrDefault(response.badgeId, badgeId);
    this.imageUrl = response.imageUrl;
    this.name = response.name;
    this.description = response.description;
    this.hint = response.hint;
    this.sponsor = response.sponsor;
    this.amount = response.amount;
    this.sortOrder = response.sortOrder;
  }

  public String getBadgeId() {
    return badgeId;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getHint() {
    return hint;
  }

  public boolean isSponsor() {
    return sponsor;
  }

  public int getAmount() {
    return amount;
  }

  public int getSortOrder() {
    return sortOrder;
  }
}
