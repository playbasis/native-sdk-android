package com.playbasis.pbcore.rest.form.content;

import com.playbasis.pbcore.rest.form.CustomFieldForm;

/**
 * Created by Tar on 4/21/16 AD.
 */
public abstract class ContentOpinionForm extends CustomFieldForm {

  protected String contentId;
  protected String playerId;

  public ContentOpinionForm(String contentId, String playerId) {
    this.contentId = contentId;
    this.playerId = playerId;
  }

  public String getNodeId() {
    return contentId;
  }

  public String getPlayerId() {
    return playerId;
  }
}
