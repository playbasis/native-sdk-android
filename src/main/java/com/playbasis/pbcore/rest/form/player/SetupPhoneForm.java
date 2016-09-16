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

  public SetupPhoneForm(String playerId, String phoneNumber) {
    this.playerId = playerId;
    this.phoneNumber = phoneNumber;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("device_token", deviceToken);
    map.put("device_name", deviceName);
    map.put("device_description", deviceDescription);
    map.put("os_type", osType);

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
