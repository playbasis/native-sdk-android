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

  public Player player;
  public String playerId;
  public String firstName;
  public String lastName;
  public Birthdate birthDate;
  public Gender gender;
  public File profilePictureFile;
  public String imageUrl;

  public UpdatePlayerForm(Player player, boolean preload) {
    this.player = player;
    this.playerId = player.playerId;

    if (preload) {
      this.firstName = player.firstName;
      this.lastName = player.lastName;
      this.birthDate = player.birthday;
      this.gender = player.gender;
    }
  }

  public boolean isValidForm() {
    return Validator.isValid(playerId);
  }
}
