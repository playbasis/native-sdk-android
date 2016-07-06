package com.playbasis.pbcore.rest.form;

import com.smartsoftasia.ssalibrary.helper.Validator;

/**
 * Created by Tar on 4/21/16 AD.
 */
public abstract class BaseUserForm extends PBForm {

  protected String email;
  protected String password;
  protected String userName;

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

  public boolean isUserNameValid(){
    return Validator.isValid(userName);
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

  public String getUserName(){
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}
