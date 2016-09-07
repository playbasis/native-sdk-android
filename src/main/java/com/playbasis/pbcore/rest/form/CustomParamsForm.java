package com.playbasis.pbcore.rest.form;

import java.util.HashMap;

/**
 * Created by Tar on 9/7/16 AD.
 */
public class CustomParamsForm extends PBForm {

  protected HashMap<String, String> customParams = new HashMap<>();

  public void addParam(String key, String value) {
    if (key != null && value != null) {
      customParams.put(key, value);
    }
  }

  public void removeParam(String key) {
    if (key != null) {
      customParams.remove(key);
    }
  }

  public void setCustomParams(HashMap<String, String> customParams) {
    this.customParams = customParams;
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
