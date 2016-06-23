package com.playbasis.pbcore.rest.form;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetQuestListForm extends PBForm {

  private String tags;

  public GetQuestListForm() {

  }

  public GetQuestListForm(String tags) {
    this.tags = tags;
  }

  public String getTags() {
    return tags;
  }
}
