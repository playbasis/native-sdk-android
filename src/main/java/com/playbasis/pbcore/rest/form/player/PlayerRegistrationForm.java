package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.domain.model.Birthdate;
import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class PlayerRegistrationForm extends PBForm {

  protected String playerId;
  protected String userName;
  protected String email;
  protected String image = "https://www.pbapp.net/images/default_profile.jpg";
  protected String phoneNumber = null;
  protected String facebookId = null;
  protected String twitterId = null;
  protected String password = null;
  protected String firstName = null;
  protected String lastName = null;
  protected int gender = 0;
  protected Birthdate birthDate;
  protected String code = null;
  protected int anonymous = -1;
  protected String deviceId = null;
  protected String status = null;

  public PlayerRegistrationForm(String playerId, String userName, String email) {
    this.playerId = playerId;
    this.userName = userName;
    this.email = email;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("image", image);
    map.put("phone_number", phoneNumber);
    map.put("facebook_id", facebookId);
    map.put("twitter_id", twitterId);
    map.put("password", password);
    map.put("first_name", firstName);
    map.put("last_name", lastName);

    if (gender == 1 || gender == 2) {
      map.put("gender", gender);
    }

    map.put("birth_date", getBirthdateValue());
    map.put("code", code);

    if (anonymous == 0 || anonymous == 1) {
      map.put("anonymous", anonymous);
    }

    map.put("device_id", deviceId);
    map.put("approve_status", status);

    return map;
  }

  public String getBirthdateValue() {
    if (birthDate != null) {
      return birthDate.getParamValue();
    }

    return null;
  }

  public String getPlayerId() {
    return playerId;
  }

  public String getUserName() {
    return userName;
  }

  public String getEmail() {
    return email;
  }

  public String getImage() {
    return image;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getFacebookId() {
    return facebookId;
  }

  public String getTwitterId() {
    return twitterId;
  }

  public String getPassword() {
    return password;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getGender() {
    return gender;
  }

  public Birthdate getBirthDate() {
    return birthDate;
  }

  public String getCode() {
    return code;
  }

  public int getAnonymous() {
    return anonymous;
  }

  public String getDeviceId() {
    return deviceId;
  }

  public String getStatus() {
    return status;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setFacebookId(String facebookId) {
    this.facebookId = facebookId;
  }

  public void setTwitterId(String twitterId) {
    this.twitterId = twitterId;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }

  public void setBirthDate(Birthdate birthDate) {
    this.birthDate = birthDate;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public void setAnonymous(int anonymous) {
    this.anonymous = anonymous;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
