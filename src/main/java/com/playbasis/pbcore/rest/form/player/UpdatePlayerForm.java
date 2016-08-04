package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.domain.model.Birthdate;
import com.playbasis.pbcore.domain.model.Gender;
import com.playbasis.pbcore.domain.model.Player;
import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;
import com.smartsoftasia.ssalibrary.helper.Validator;

import java.io.File;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class UpdatePlayerForm extends PBForm {

  protected Player player;
  protected String playerId;
  protected String firstName;
  protected String lastName;
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

    map.put("username", null);
    map.put("email", null);
    map.put("image", imageUrl);
    map.put("phone_number", null);
    map.put("exp", null);
    map.put("level", null);
    map.put("facebook_id", null);
    map.put("twitter_id", null);
    map.put("password", null);
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
