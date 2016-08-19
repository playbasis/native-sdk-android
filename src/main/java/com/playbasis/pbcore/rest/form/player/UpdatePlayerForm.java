package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.domain.model.Birthdate;
import com.playbasis.pbcore.helper.Validator;
import com.playbasis.pbcore.rest.form.BaseUserForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class UpdatePlayerForm extends BaseUserForm {

  protected String playerId;
  protected String firstName;
  protected String lastName;
  protected String exp;
  protected String level;
  protected String facebookId;
  protected String twitterId;
  protected String phoneNumber;
  protected Birthdate birthDate;
  protected int gender;
  protected String imageUrl;

  public UpdatePlayerForm(String playerId) {
    this.playerId = playerId;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("username", userName);
    map.put("email", email);
    map.put("image", imageUrl);
    map.put("phone_number", phoneNumber);
    map.put("exp", exp);
    map.put("level", level);
    map.put("facebook_id", facebookId);
    map.put("twitter_id", twitterId);
    map.put("password", password);
    map.put("first_name", firstName);
    map.put("last_name", lastName);
    map.put("gender", gender);
    map.put("birth_date", getBirthdateValue());
    map.put("device_id", null);

    return map;
  }

  public boolean isValidForm() {
    return Validator.isValid(playerId);
  }

  public String getPlayerId() {
    return playerId;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
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

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setBirthDate(Birthdate birthDate) {
    this.birthDate = birthDate;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getBirthdateValue() {
    if (birthDate != null) {
      return birthDate.getParamValue();
    }

    return null;
  }
}
