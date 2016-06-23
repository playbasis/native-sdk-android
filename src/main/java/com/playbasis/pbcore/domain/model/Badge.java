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

  public static ArrayList<Badge> create(List<BadgeResponse> responses) {
    ArrayList<Badge> badges = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return badges;
    }

    for (BadgeResponse badgeResponse : responses) {
      Badge badge = new Badge();
      badge.init(badgeResponse);
      badges.add(badge);
    }

    return badges;
  }

  public void init(BadgeResponse badgeResponse) {
    this.badgeId = badgeResponse.badgeId;
    this.imageUrl = badgeResponse.imageUrl;
    this.name = badgeResponse.name;
    this.description = badgeResponse.description;
    this.hint = badgeResponse.hint;
    this.sponsor = badgeResponse.sponsor;
    this.amount = badgeResponse.amount;
    this.sortOrder = badgeResponse.sortOrder;
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
