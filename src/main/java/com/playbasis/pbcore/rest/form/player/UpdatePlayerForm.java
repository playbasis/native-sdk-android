package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.domain.model.Birthdate;
import com.playbasis.pbcore.domain.model.Gender;
import com.playbasis.pbcore.domain.model.Player;
import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;
import com.playbasis.pbcore.helper.Validator;

import java.io.File;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class UpdatePlayerForm extends PBForm {

  protected Player player;
  protected String playerId;
  protected String firstName;
  protected String lastName;
  protected String userName;
  protected String exp;
  protected String level;
  protected String facebookId;
  protected String twitterId;
  protected String password;
  protected String phoneNumber;
  protected String email;
  protected Birthdate birthDate;
  protected Gender gender;
  protected File profilePictureFile;
  protected String imageUrl;

  public UpdatePlayerForm(String playerId) {
    this.playerId = playerId;
  }

  public UpdatePlayerForm(Player player, boolean preload) {
    this.player = player;
    this.playerId = player.getPlayerId();

    if (preload) {
      this.firstName = player.getFirstName();
      this.lastName = player.getLastName();
      this.birthDate = player.getBirthday();
      this.gender = player.getGender();
    }
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
    map.put("gender", getGenderValue());
    map.put("birth_date", getBirthdateValue());
    map.put("device_id", null);

    return map;
  }

  public boolean isValidForm() {
    return Validator.isValid(playerId);
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
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

  public Birthdate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Birthdate birthDate) {
    this.birthDate = birthDate;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public File getProfilePictureFile() {
    return profilePictureFile;
  }

  public void setProfilePictureFile(File profilePictureFile) {
    this.profilePictureFile = profilePictureFile;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getBirthdateValue() {
    if (getBirthDate() != null) {
      return getBirthDate().getParamValue();
    }

    return null;
  }

  public String getGenderValue() {
    if (getGender() != null) {
      return getGender().getValue();
    }

    return null;
  }
}
