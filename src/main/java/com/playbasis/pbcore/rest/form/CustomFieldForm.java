package com.playbasis.pbcore.rest.form;

import android.text.TextUtils;

import com.smartsoftasia.ssalibrary.helper.Validator;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Tar on 5/27/16 AD.
 */
public class CustomFieldForm extends PBForm {

  protected HashMap<String, String> customFieldMap = new HashMap<>();

  public String getKeys() {
    ArrayList<String> keys = new ArrayList<>();

    if (customFieldMap != null) {
      for (String key : customFieldMap.keySet()) {

        if (customFieldMap.get(key) != null) {
          keys.add(key);
        }
      }
    }

    return TextUtils.join(",", keys);
  }

  public String getValues() {
    ArrayList<String> values = new ArrayList<>();

    if (customFieldMap != null) {
      for (String key : customFieldMap.keySet()) {
        String value = customFieldMap.get(key);

        if (value != null) {
          values.add(value);
        }
      }
    }
    return TextUtils.join(",", values);
  }

  public void setCustomField(String key, String value) {
    if (Validator.isValid(key) && value != null) {
      customFieldMap.put(key, value);
    }
  }

  public void removeCustomField(String key) {
    customFieldMap.remove(key);
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap hashMap = super.getFields();
    hashMap.put("key", getKeys());
    hashMap.put("value", getValues());

    return hashMap;
  }
}
