package com.playbasis.pbcore.domain.model;

import android.support.annotation.StringDef;

import com.playbasis.pbcore.rest.result.GetUserCustomFieldsApiResult;
import com.playbasis.pbcore.rest.result.response.GetPlayerInfoResponse;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;

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
  protected Gender gender;
  protected ArrayList<Badge> badges;
  protected HashMap<String, String> customFields = new HashMap<>();

  public Player(String playerId) {
    this.playerId = playerId;
  }

  public void update(GetPlayerInfoResponse getPlayerInfoResponse) {
    if (getPlayerInfoResponse.playerId != null) {
      this.playerId = getPlayerInfoResponse.playerId;
    }

    this.email = getPlayerInfoResponse.email;
    this.firstName = getPlayerInfoResponse.firstName;
    this.lastName = getPlayerInfoResponse.lastName;
    this.gender = new Gender(getPlayerInfoResponse.gender);
    this.birthday = getPlayerInfoResponse.birthdate;
    this.imageUrl = getPlayerInfoResponse.image;
    this.phoneNumber = getPlayerInfoResponse.phoneNumber;
    this.registered = getPlayerInfoResponse.registered;
    this.lastLogin = getPlayerInfoResponse.lastLogin;
    this.lastLogout = getPlayerInfoResponse.lastLogout;
    this.levelPercent = getPlayerInfoResponse.levelPercent;
    this.levelTitle = getPlayerInfoResponse.levelTitle;
    this.levelImageUrl = getPlayerInfoResponse.levelImageUrl;
    this.badges = Badge.create(getPlayerInfoResponse.playerBadgesResponses);
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

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public ArrayList<Badge> getBadges() {
    return badges;
  }

  public HashMap<String, String> getCustomFields() {
    return customFields;
  }

  public void setCustomFields(HashMap<String, String> customFields) {
    this.customFields = customFields;
  }
}
