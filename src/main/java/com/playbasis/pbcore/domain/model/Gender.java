package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.R;
import com.smartsoftasia.ssalibrary.helper.TranslationHelper;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class Gender extends PBModel {

  public static final String MALE = "1";
  public static final String FEMALE = "2";

  public String title;
  public String value;

  public Gender(String title, String value) {
    this.title = title;
    this.value = value;
  }

  public Gender(String value) {
    this.value = value;

    if (value.equalsIgnoreCase(MALE)) {
      this.title = TranslationHelper.get(R.string.global_male);
    } else if (value.equalsIgnoreCase(FEMALE)) {
      this.title = TranslationHelper.get(R.string.global_female);
    }
  }

  public Gender(int value) {
    this(String.valueOf(value));
  }
}
