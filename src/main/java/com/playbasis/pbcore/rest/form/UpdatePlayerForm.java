package com.playbasis.pbcore.rest.form;

import com.playbasis.pbcore.domain.model.Birthdate;
import com.playbasis.pbcore.domain.model.Gender;
import com.playbasis.pbcore.domain.model.Player;
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

  public void setPlayerId(String playerId) {
    this.playerId = playerId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
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

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
