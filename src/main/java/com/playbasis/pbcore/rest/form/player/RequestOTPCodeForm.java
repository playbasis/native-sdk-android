package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class RequestOTPCodeForm extends PBForm {

  protected String playerId;
  protected String deviceToken = null;
  protected String deviceDescription = null;
  protected String deviceName = null;
  protected String osType = null;

  public RequestOTPCodeForm(String playerId) {
    this.playerId = playerId;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("device_token", deviceToken);
    map.put("device_description", deviceDescription);
    map.put("device_name", deviceName);
    map.put("os_type", osType);

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

  public String getOsType() {
    return osType;
  }

  public void setDeviceToken(String deviceToken) {
    this.deviceToken = deviceToken;
  }

  public void setDeviceDescription(String deviceDescription) {
    this.deviceDescription = deviceDescription;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public void setOsType(String osType) {
    this.osType = osType;
  }
}
