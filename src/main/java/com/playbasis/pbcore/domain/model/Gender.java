package com.playbasis.pbcore.domain.model;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class Gender extends PBModel {

  public static final String MALE = "1";
  public static final String FEMALE = "2";

  protected String title;
  protected String value;

  public Gender(String title, String value) {
    this.title = title;
    this.value = value;
  }

  public Gender(String value) {
    this.value = value;

    if (value.equalsIgnoreCase(MALE)) {
      this.title = "Male";
    } else if (value.equalsIgnoreCase(FEMALE)) {
      this.title = "Female";
    }
  }

  public Gender(int value) {
    this(String.valueOf(value));
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
