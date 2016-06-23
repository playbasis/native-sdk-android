package com.playbasis.pbcore.rest.form.content;

import com.playbasis.pbcore.domain.model.Player;
import com.playbasis.pbcore.rest.form.PBForm;
import com.smartsoftasia.ssalibrary.helper.Validator;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class CountContentForm extends PBForm {

  public static final String TAG = "CountContentForm";

  protected String category = null;
  protected Player player = null;
  protected String pin = null;

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
      return player.getPlayerId();
    }

    return null;
  }

  public boolean isGetOnlyNewContent() {
    return player != null && Validator.isValid(player.getPlayerId());
  }
}
