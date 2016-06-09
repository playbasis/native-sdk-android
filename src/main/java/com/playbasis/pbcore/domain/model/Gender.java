package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.R;
import com.smartsoftasia.ssalibrary.helper.TranslationHelper;

import java.util.ArrayList;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class Gender extends PBModel {

  public static final String MALE = "1";
  public static final String FEMALE = "2";

  public static ArrayList<Gender> genders = null;

  public String title;
  public String value;

  public static ArrayList<Gender> all() {
    if (genders == null) {
      genders = new ArrayList<>();
      genders.add(new Gender(TranslationHelper.get(R.string.global_male), MALE));
      genders.add(new Gender(TranslationHelper.get(R.string.global_female), FEMALE));
    }

    return genders;
  }

  public static Gender find(int value) {
    for (Gender gender : all()) {
      if (gender.value == String.valueOf(value)) {
        return gender;
      }
    }

    return null;
  }

  public Gender(String title, String value) {
    this.title = title;
    this.value = value;
  }

}
