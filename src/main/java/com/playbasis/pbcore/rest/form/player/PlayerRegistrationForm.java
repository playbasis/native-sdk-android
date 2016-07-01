package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.BaseUserForm;
import com.smartsoftasia.ssalibrary.helper.Validator;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class PlayerRegistrationForm extends BaseUserForm {

  protected String playerId;
  protected String userName;
  protected String imageUrl;
  protected String status;

  public PlayerRegistrationForm(String email, String password) {
    super(email, password);

    status = "approved";
  }

  public boolean isUserNameValid(){
    return Validator.isValid(userName);
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

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
