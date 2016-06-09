package com.playbasis.pbcore.domain.model;

import android.support.annotation.StringDef;

import com.playbasis.pbcore.rest.result.GetUserCustomFieldsApiResult;
import com.playbasis.pbcore.rest.result.response.GetUserInfoResponse;

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
  public String userId;
  public String imageUrl;
  public String phoneNumber;
  public String registered;
  public String lastLogin;
  public String lastLogout;
  public Gender gender;
  public HashMap<String, String> customFieldMap = new HashMap<>();

  public Player(String userId) {
    this.userId = userId;
  }

  public void update(GetUserInfoResponse getUserInfoResponse) {
    if (getUserInfoResponse.userId != null) {
      this.userId = getUserInfoResponse.userId;
    }

    this.email = getUserInfoResponse.email;
    this.firstName = getUserInfoResponse.firstName;
    this.lastName = getUserInfoResponse.lastName;
    this.gender = new Gender(getUserInfoResponse.gender);
    this.birthday = getUserInfoResponse.birthdate;
    this.imageUrl = getUserInfoResponse.image;
    this.phoneNumber = getUserInfoResponse.phoneNumber;
    this.registered = getUserInfoResponse.registered;
    this.lastLogin = getUserInfoResponse.lastLogin;
    this.lastLogout = getUserInfoResponse.lastLogout;
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
