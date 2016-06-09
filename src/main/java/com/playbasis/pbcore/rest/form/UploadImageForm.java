package com.playbasis.pbcore.rest.form;

import java.io.File;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class UploadImageForm extends PBForm {

  private String playerId;
  private File file;

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
}
