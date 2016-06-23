package com.playbasis.pbcore.rest.form.file;

import com.playbasis.pbcore.rest.form.PBForm;

import java.io.File;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class UploadImageForm extends PBForm {

  protected String playerId;
  protected File file;

  public UploadImageForm(String playerId, File file) {
    this.playerId = playerId;
    this.file = file;
  }

  public String getPlayerId() {
    return playerId;
  }

  public File getFile() {
    return file;
  }

  public void setFile(File file) {
    this.file = file;
  }
}
