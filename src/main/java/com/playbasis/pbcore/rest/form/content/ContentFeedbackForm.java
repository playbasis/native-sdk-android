package com.playbasis.pbcore.rest.form.content;

/**
 * Created by Tar on 5/26/16 AD.
 */
public class ContentFeedbackForm extends ContentOpinionForm {

  protected String comment = null;

  public ContentFeedbackForm(String contentId, String playerId) {
    super(contentId, playerId);
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
