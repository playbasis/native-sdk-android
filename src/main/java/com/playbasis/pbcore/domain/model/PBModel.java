package com.playbasis.pbcore.domain.model;

import android.os.Parcelable;

/**
 * Created by Tar on 4/20/16 AD.
 */
public abstract class PBModel implements Parcelable {

  public <T> T valueOrDefault(T value, T defaultValue) {
    if (value != null) {
      return value;
    }

    return defaultValue;
  }

}
