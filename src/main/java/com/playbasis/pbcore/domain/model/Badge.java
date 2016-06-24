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

  public void init(BadgeResponse response) {
    init(response, true);
  }

  public void init(BadgeResponse response, boolean allowNull) {
    if (response == null) {
      return;
    }

    this.badgeId = valueOrDefault(response.badgeId, this.badgeId);
    this.imageUrl = valueOrDefault(response.imageUrl, this.imageUrl, allowNull);
    this.name = valueOrDefault(response.name, this.name, allowNull);
    this.description = valueOrDefault(response.description, this.description, allowNull);
    this.hint = valueOrDefault(response.hint, this.hint, allowNull);
    this.sponsor = valueOrDefault(response.sponsor, this.sponsor, allowNull);
    this.amount = valueOrDefault(response.amount, this.amount, allowNull);
    this.sortOrder = valueOrDefault(response.sortOrder, this.sortOrder, allowNull);
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
