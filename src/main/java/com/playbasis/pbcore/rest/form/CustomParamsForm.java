package com.playbasis.pbcore.rest.form;

import java.util.HashMap;

/**
 * Created by Tar on 9/7/16 AD.
 */
public class CustomParamsForm extends PBForm {

  protected HashMap<String, String> customParams = new HashMap<>();

  public void addParam(String key, String value) {
    if (key != null && value != null) {
      getCustomParams().put(key, value);
    }
  }

  public void removeParam(String key) {
    if (key != null) {
      getCustomParams().remove(key);
    }
  }

  public void setCustomParams(HashMap<String, String> customParams) {
    this.customParams = customParams;
  }

  private HashMap<String, String> getCustomParams() {
    if (customParams == null) {
      customParams = new HashMap<>();
    }

    return customParams;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    if (customParams != null) {
      for (String key : customParams.keySet()) {
        map.put(key, customParams.get(key));
      }
    }

    return map;
  }
}
