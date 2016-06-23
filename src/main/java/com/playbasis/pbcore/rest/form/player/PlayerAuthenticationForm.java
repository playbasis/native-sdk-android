package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.BaseUserForm;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class PlayerAuthenticationForm extends BaseUserForm {

  public PlayerAuthenticationForm(String email, String password) {
    super(email,password);
  }
}
