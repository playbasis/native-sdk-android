package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.helper.Validator;
import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class PlayerAuthenticationForm extends PBForm {

  protected String email;
  protected String password;
  protected String userName;
  protected String deviceToken;

  public PlayerAuthenticationForm(String username, String password) {
    this.userName = username;
    this.password = password;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    if (Validator.isValid(userName)) {
      map.put("username", userName);
    } else if (Validator.isValid(email)) {
      map.put("email", email);
    }

    map.put("device_token", deviceToken);

    return map;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getUserName() {
    return userName;
  }

  public String getDeviceToken() {
    return deviceToken;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setDeviceToken(String deviceToken) {
    this.deviceToken = deviceToken;
  }
}
