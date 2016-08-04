package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.BaseUserForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class PlayerRegistrationForm extends BaseUserForm {

  protected String playerId;
  protected String imageUrl;
  protected String status;

  public PlayerRegistrationForm(String email, String userName, String password) {
    this.email = email;
    this.userName = userName;
    this.password = password;
    this.status = "approved";
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
    map.put("phone_number", null);
    map.put("facebook_id", null);
    map.put("twitter_id", null);
    map.put("password", null);
    map.put("first_name", null);
    map.put("last_name", null);
    map.put("gender", null);
    map.put("birth_date", null);
    map.put("code", null);
    map.put("anonymous", null);
    map.put("device_id", null);
    map.put("approve_status", status);

    return map;
  }
}
