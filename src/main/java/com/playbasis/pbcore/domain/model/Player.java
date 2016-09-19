package com.playbasis.pbcore.domain.model;

import android.os.Parcel;
import android.support.annotation.StringDef;

import com.playbasis.pbcore.rest.response.BadgeResponse;
import com.playbasis.pbcore.rest.response.GoodsResponse;
import com.playbasis.pbcore.rest.response.PlayerResponse;
import com.playbasis.pbcore.rest.response.PointResponse;
import com.playbasis.pbcore.rest.result.player.GetUserCustomFieldsApiResult;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class Player extends PBModel {

  public static final String APPROVED = "approved";
  public static final String REJECTED = "rejected";
  public static final String PENDING = "pending";

  @StringDef(value = {APPROVED, REJECTED, PENDING})
  @Retention(RetentionPolicy.SOURCE)
  public @interface ApproveStatus {

  }

  protected String firstName;
  protected String lastName;
  protected String email;
  protected Birthdate birthday;
  protected String playerId;
  protected String imageUrl;
  protected String phoneNumber;
  protected String registered;
  protected String lastLogin;
  protected String lastLogout;
  protected float levelPercent;
  protected String levelTitle;
  protected String levelImageUrl;
  protected int gender;
  protected ArrayList<Badge> badges;
  protected ArrayList<Goods> goods;
  protected ArrayList<Point> points;
  protected HashMap<String, String> customFields = new HashMap<>();

  @Override
  public boolean equals(Object o) {
    if (o instanceof Player) {
      String playerId = ((Player) o).getPlayerId();

      return playerId != null && playerId.equals(getPlayerId());
    }
    return super.equals(o);
  }

  protected ArrayList<Badge> createBadges(List<BadgeResponse> badgeResponses) {
    return Badge.createBadges(badgeResponses);
  }

  protected ArrayList<Goods> createGoods(List<GoodsResponse> goodsResponses) {
    return Goods.createGoods(goodsResponses);
  }

  protected ArrayList<Point> createPoints(List<PointResponse> pointResponses) {
    return Point.createPoints(pointResponses);
  }

  public Player(String playerId) {
    this.playerId = playerId;
  }

  public Player(PlayerResponse response) {
    update(response);
  }

  public void update(PlayerResponse response) {
    if (response == null) {
      return;
    }

    this.playerId = valueOrDefault(response.playerId, playerId);
    this.email = response.email;
    this.firstName = response.firstName;
    this.lastName = response.lastName;
    this.birthday = response.birthdate;
    this.imageUrl = response.image;
    this.phoneNumber = response.phoneNumber;
    this.registered = response.registered;
    this.lastLogin = response.lastLogin;
    this.lastLogout = response.lastLogout;
    this.levelPercent = response.levelPercent;
    this.levelTitle = response.levelTitle;
    this.levelImageUrl = response.levelImageUrl;
    this.gender = response.gender;
    this.badges = createBadges(response.playerBadgesResponses);
    this.goods = createGoods(response.playerGoodsResponses);
    this.points = createPoints(response.playerPointsResponses);
  }

  public void update(GetUserCustomFieldsApiResult getUserCustomFieldsApiResult) {
    this.customFields.clear();

    if (getUserCustomFieldsApiResult.getCustomFieldMap() != null) {
      this.customFields.putAll(getUserCustomFieldsApiResult.getCustomFieldMap());
    }
  }

  public String getField(String key) {
    return customFields.get(key);
  }

  public boolean hasField(String key) {
    return customFields.containsKey(key);
  }

  public String getPlayerId() {
    return playerId;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public Birthdate getBirthday() {
    return birthday;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public String getRegistered() {
    return registered;
  }

  public String getLastLogin() {
    return lastLogin;
  }

  public String getLastLogout() {
    return lastLogout;
  }

  public float getLevelPercent() {
    return levelPercent;
  }

  public String getLevelImageUrl() {
    return levelImageUrl;
  }

  public String getLevelTitle() {
    return levelTitle;
  }

  public int getGender() {
    return gender;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }

  public ArrayList<Badge> getBadges() {
    return badges;
  }

  public ArrayList<Goods> getGoods() {
    return goods;
  }

  public HashMap<String, String> getCustomFields() {
    return customFields;
  }

  public void setCustomFields(HashMap<String, String> customFields) {
    this.customFields = customFields;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.firstName);
    dest.writeString(this.lastName);
    dest.writeString(this.email);
    dest.writeSerializable(this.birthday);
    dest.writeString(this.playerId);
    dest.writeString(this.imageUrl);
    dest.writeString(this.phoneNumber);
    dest.writeString(this.registered);
    dest.writeString(this.lastLogin);
    dest.writeString(this.lastLogout);
    dest.writeFloat(this.levelPercent);
    dest.writeString(this.levelTitle);
    dest.writeString(this.levelImageUrl);
    dest.writeInt(this.gender);
    dest.writeTypedList(this.badges);
    dest.writeTypedList(this.goods);
    dest.writeTypedList(this.points);
    dest.writeSerializable(this.customFields);
  }

  protected Player(Parcel in) {
    this.firstName = in.readString();
    this.lastName = in.readString();
    this.email = in.readString();
    this.birthday = (Birthdate) in.readSerializable();
    this.playerId = in.readString();
    this.imageUrl = in.readString();
    this.phoneNumber = in.readString();
    this.registered = in.readString();
    this.lastLogin = in.readString();
    this.lastLogout = in.readString();
    this.levelPercent = in.readFloat();
    this.levelTitle = in.readString();
    this.levelImageUrl = in.readString();
    this.gender = in.readInt();
    this.badges = in.createTypedArrayList(Badge.CREATOR);
    this.goods = in.createTypedArrayList(Goods.CREATOR);
    this.points = in.createTypedArrayList(Point.CREATOR);
    this.customFields = (HashMap<String, String>) in.readSerializable();
  }

  public static final Creator<Player> CREATOR = new Creator<Player>() {
    @Override
    public Player createFromParcel(Parcel source) {
      return new Player(source);
    }

    @Override
    public Player[] newArray(int size) {
      return new Player[size];
    }
  };
}
