package com.playbasis.pbcore.domain.model;

import android.support.annotation.StringDef;

import com.playbasis.pbcore.rest.result.GetUserCustomFieldsApiResult;
import com.playbasis.pbcore.rest.result.response.GetPlayerInfoResponse;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
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

  public String firstName;
  public String lastName;
  public String email;
  public Birthdate birthday;
  public String playerId;
  public String imageUrl;
  public String phoneNumber;
  public String registered;
  public String lastLogin;
  public String lastLogout;
  public Gender gender;
  public HashMap<String, String> customFieldMap = new HashMap<>();

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
  }

  public void update(GetUserCustomFieldsApiResult getUserCustomFieldsApiResult) {
    this.customFieldMap.clear();

    if (getUserCustomFieldsApiResult.getCustomFieldMap() != null) {
      this.customFieldMap.putAll(getUserCustomFieldsApiResult.getCustomFieldMap());
    }
  }

  public String getField(String key) {
    return customFieldMap.get(key);
  }

  public boolean hasField(String key) {
    return customFieldMap.containsKey(key);
  }
}
