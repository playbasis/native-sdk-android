package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class SetupPhoneForm extends PBForm {

  protected String playerId;
  protected String phoneNumber;
  protected String deviceToken = null;
  protected String deviceDescription = null;
  protected String deviceName = null;
  protected final String osType = "Android";

  public SetupPhoneForm(String playerId, String phoneNumber, String deviceToken, String deviceDescription, String deviceName) {
    this.playerId = playerId;
    this.phoneNumber = phoneNumber;
    this.deviceToken = deviceToken;
    this.deviceDescription = deviceDescription;
    this.deviceName = deviceName;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    return map;
  }

  public String getPlayerId() {
    return playerId;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getDeviceToken() {
    return deviceToken;
  }

  public String getDeviceDescription() {
    return deviceDescription;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public String getOSType() {
    return osType;
  }
}
