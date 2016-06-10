package com.playbasis.pbcore.rest.form;

import com.playbasis.pbcore.domain.model.Player;
import com.smartsoftasia.ssalibrary.helper.Validator;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class CountContentForm extends PBForm {

  public static final String TAG = "CountContentForm";

  public String category = null;
  public Player player = null;
  public String pin = null;

  public CountContentForm(String category) {
    this.category = category;
  }

  public CountContentForm(String category, Player player) {
    this.category = category;
    this.player = player;
  }

  public String getCategory() {
    return category;
  }

  public String getPin() {
    return pin;
  }

  public String getPlayerId() {
    if (player != null) {
      return player.playerId;
    }

    return null;
  }

  public boolean isGetOnlyNewContent() {
    return player != null && Validator.isValid(player.playerId);
  }
}
