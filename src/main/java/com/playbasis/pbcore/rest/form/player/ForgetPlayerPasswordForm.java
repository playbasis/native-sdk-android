package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.PBForm;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class ForgetPlayerPasswordForm extends PBForm {

  protected String email;

  public ForgetPlayerPasswordForm(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
