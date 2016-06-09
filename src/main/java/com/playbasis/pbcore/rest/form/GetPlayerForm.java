package com.playbasis.pbcore.rest.form;

import com.playbasis.pbcore.rest.form.PBForm;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetPlayerForm extends PBForm {

  public String userId;

  public GetPlayerForm(String userId) {
    this.userId = userId;
  }
}
