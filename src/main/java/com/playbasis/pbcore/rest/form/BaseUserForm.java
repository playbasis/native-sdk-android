package com.playbasis.pbcore.rest.form;

import com.smartsoftasia.ssalibrary.helper.Validator;

/**
 * Created by Tar on 4/21/16 AD.
 */
public abstract class BaseUserForm extends PBForm {

  private String email;
  private String password;

  public BaseUserForm(String email, String password) {
    this.email = email;
    this.password = password;
  }

  /**
   * This method return true if the email is valid.
   * @return email is valid
   */
  public boolean isEmailValid(){
    return Validator.isValidEmail(email);
  }

  /**
   * The method return tru if the password is valid.
   * @return password is valid
   */
  public boolean isPasswordValid(){
    return Validator.isValidPassword(password);
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
