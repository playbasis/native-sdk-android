package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class VerifyOTPCodeForm extends PBForm {

  protected String playerId;
  protected String code;

  public VerifyOTPCodeForm(String playerId, String code) {
    this.playerId = playerId;
    this.code = code;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    return map;
  }

  public String getPlayerId() {
    return playerId;
  }

  public String getCode() {
    return code;
  }
}
