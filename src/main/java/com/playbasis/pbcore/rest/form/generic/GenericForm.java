package com.playbasis.pbcore.rest.form.generic;

import com.playbasis.pbcore.rest.form.CustomParamsForm;

/**
 * Created by Tar on 11/2/16.
 */

public class GenericForm extends CustomParamsForm {

  private String url;

  public GenericForm(String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }
}
