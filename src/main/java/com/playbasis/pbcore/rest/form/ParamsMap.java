package com.playbasis.pbcore.rest.form;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tar on 8/4/16 AD.
 */
public class ParamsMap extends HashMap<String, String> {

  @Override
  public String put(String key, String value) {
    if (key == null || value == null) {
      return "";
    }

    return super.put(key, value);
  }

  @Override
  public void putAll(Map<? extends String, ? extends String> map) {
    super.putAll(map);
  }

  public String put(String key, boolean value) {
    return put(key, value ? "true" : "false");
  }

  public String put(String key, int value) {
    return put(key, String.valueOf(value));
  }

  public String put(String key, double value) {
    return put(key, String.valueOf(value));
  }

  public String put(String key, long value) {
    return put(key, String.valueOf(value));
  }
}
