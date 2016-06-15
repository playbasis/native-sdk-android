package com.playbasis.pbcore.rest.form;

import com.smartsoftasia.ssalibrary.helper.Validator;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class PlayerRegistrationForm extends BaseUserForm {

  protected String playerId;
  protected String userName;
  protected String imageUrl;

  public PlayerRegistrationForm(String email, String password) {
    super(email, password);
  }

  public boolean isUserNameValid(){
    return Validator.isValidEmail(userName);
  }

  public String getPlayerId(){
    return playerId;
  }

  public void setPlayerId(String playerId) {
    this.playerId = playerId;
  }

  public String getUserName(){
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getImageUrl(){
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
