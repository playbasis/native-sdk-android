package com.playbasis.pbcore.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

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

  public static ArrayList<Badge> createBadges(List<BadgeResponse> responses) {
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

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.badgeId);
    dest.writeString(this.imageUrl);
    dest.writeString(this.name);
    dest.writeString(this.description);
    dest.writeString(this.hint);
    dest.writeByte(this.sponsor ? (byte) 1 : (byte) 0);
    dest.writeInt(this.amount);
    dest.writeInt(this.sortOrder);
  }

  protected Badge(Parcel in) {
    this.badgeId = in.readString();
    this.imageUrl = in.readString();
    this.name = in.readString();
    this.description = in.readString();
    this.hint = in.readString();
    this.sponsor = in.readByte() != 0;
    this.amount = in.readInt();
    this.sortOrder = in.readInt();
  }

  public static final Creator<Badge> CREATOR = new Creator<Badge>() {
    @Override
    public Badge createFromParcel(Parcel source) {
      return new Badge(source);
    }

    @Override
    public Badge[] newArray(int size) {
      return new Badge[size];
    }
  };
}
