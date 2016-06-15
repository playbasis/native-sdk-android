package com.playbasis.pbcore.rest.form;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class PlayerRegistrationForm extends BaseUserForm {

  private String playerId;
  private String userName;
  private String imageUrl;

  public PlayerRegistrationForm(String email, String password) {
    super(email, password);
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
