package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.domain.model.Birthdate;
import com.playbasis.pbcore.rest.form.BaseUserForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class PlayerRegistrationForm extends BaseUserForm {

  protected String playerId;
  protected String firstName;
  protected String lastName;
  protected String facebookId;
  protected String twitterId;
  protected String phoneNumber;
  protected Birthdate birthDate;
  protected int gender;
  protected String imageUrl;
  protected String status = "approved";

  public PlayerRegistrationForm(String email, String userName, String password) {
    this.email = email;
    this.userName = userName;
    this.password = password;
  }

  public String getPlayerId(){
    return playerId;
  }

  public void setPlayerId(String playerId) {
    this.playerId = playerId;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("image", imageUrl);
    map.put("phone_number", phoneNumber);
    map.put("facebook_id", facebookId);
    map.put("twitter_id", twitterId);
    map.put("password", password);
    map.put("first_name", firstName);
    map.put("last_name", lastName);
    map.put("gender", gender);
    map.put("birth_date", getBirthdateValue());
    map.put("code", null);
    map.put("anonymous", null);
    map.put("device_id", null);
    map.put("approve_status", status);

    return map;
  }

  public String getBirthdateValue() {
    if (birthDate != null) {
      return birthDate.getParamValue();
    }

    return null;
  }
}
