package com.playbasis.pbcore.rest.form.communication;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class DeviceRegistrationForm extends PBForm {

  protected String playerId;
  protected String deviceToken;
  protected String deviceDescription;
  protected String deviceName;
  protected final String osType = "Android";

  public DeviceRegistrationForm(String playerId, String deviceToken, String deviceDescription, String deviceName) {
    this.playerId = playerId;
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
