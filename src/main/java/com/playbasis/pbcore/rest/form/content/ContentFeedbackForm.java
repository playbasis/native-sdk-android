package com.playbasis.pbcore.rest.form.content;


import com.playbasis.pbcore.domain.model.Content;
import com.playbasis.pbcore.domain.model.Player;

/**
 * Created by Tar on 5/26/16 AD.
 */
public class ContentFeedbackForm extends ContentOpinionForm {

  protected String comment = null;
  protected String key = null;
  protected String value = null;

  public ContentFeedbackForm(Content content, Player player) {
    super(content, player);
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
