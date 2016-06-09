package com.playbasis.pbcore.rest.form;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class CountContentForm extends PBForm {

  public static final String TAG = "CountContentForm";

  public String category;

  public CountContentForm(String category) {
    this.category = category;
  }

  public String getCategory() {
    return category;
  }
}
