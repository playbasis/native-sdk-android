package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.BaseUserForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class PlayerAuthenticationForm extends BaseUserForm {

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    if (isUserNameValid()) {
      map.put("username", userName);
    } else if (isEmailValid()) {
      map.put("email", email);
    }

    return map;
  }

}
