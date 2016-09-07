package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.domain.model.Birthdate;
import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class UpdatePlayerForm extends PBForm {

  protected String playerId;
  protected String userName;
  protected String email;
  protected String image;
  protected String phoneNumber;
  protected String exp;
  protected String level;
  protected String facebookId;
  protected String twitterId;
  protected String password;
  protected String firstName;
  protected String lastName;
  protected int gender;
  protected Birthdate birthDate;
  protected String deviceId;
  protected String approveStatus;

  public UpdatePlayerForm(String playerId) {
    this.playerId = playerId;
  }

  public String getPlayerId() {
    return playerId;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setExp(String exp) {
    this.exp = exp;
  }

  public void setLevel(String level) {
    this.level = level;
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

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public void setApproveStatus(String approveStatus) {
    this.approveStatus = approveStatus;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("username", userName);
    map.put("email", email);
    map.put("image", image);
    map.put("phone_number", phoneNumber);
    map.put("exp", exp);
    map.put("level", level);
    map.put("facebook_id", facebookId);
    map.put("twitter_id", twitterId);
    map.put("password", password);
    map.put("first_name", firstName);
    map.put("last_name", lastName);

    if (gender == 1 || gender == 2) {
      map.put("gender", gender);
    }

    map.put("birth_date", getBirthdateValue());
    map.put("device_id", deviceId);
    map.put("approve_status", approveStatus);

    return map;
  }

  public String getBirthdateValue() {
    if (birthDate != null) {
      return birthDate.getParamValue();
    }

    return null;
  }
}
