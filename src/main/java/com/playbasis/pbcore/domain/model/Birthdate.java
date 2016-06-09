package com.playbasis.pbcore.domain.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Tar on 4/28/16 AD.
 */
public class Birthdate extends Date {

  public Birthdate() {

  }

  public Birthdate(Date date) {
    setTime(date.getTime());
  }

  @Override
  public String toString() {
    return new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(this);
  }

  public String getParamValue() {
    return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(this);
  }
}
