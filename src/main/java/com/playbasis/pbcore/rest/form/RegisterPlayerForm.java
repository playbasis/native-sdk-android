package com.playbasis.pbcore.rest.form;

import com.smartsoftasia.ssalibrary.helper.MD5;
import com.smartsoftasia.ssalibrary.helper.StringHelper;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class RegisterPlayerForm extends BaseUserForm {

  private String userId;
  private String userName;

  public RegisterPlayerForm(String email, String password) {
    super(email, password);
    userId = MD5.encrypt(email);

    userName = StringHelper.substringIndexOf(email, "@");
    userName = StringHelper.removeSpecialChar(userName);
    userName = userName + "_" + StringHelper.getFirstChar(MD5.encrypt(email), 5);

  }


  public String getUserId(){
    return userId;
  }


  public String getUserName(){
    return userName;
  }

  public String getImage(){
    return "https://www.pbapp.net/images/default_profile.jpg";
  }
}
