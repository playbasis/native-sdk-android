package com.playbasis.pbcore.rest.form.content;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class CountContentForm extends PBForm {

  public static final String TAG = "CountContentForm";

  protected String title = null;
  protected String category = null;
  protected boolean dateCheck = false;
  protected String pin = null;
  protected String tags = null;
  protected String status = null;
  protected String playerId = null;
  protected boolean onlyNewContent = false;
  protected boolean onlyNewFeedback = false;

  public CountContentForm() {

  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public void setDateCheck(boolean dateCheck) {
    this.dateCheck = dateCheck;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setPlayerId(String playerId) {
    this.playerId = playerId;
  }

  public void setOnlyNewContent(boolean onlyNewContent) {
    this.onlyNewContent = onlyNewContent;
  }

  public void setOnlyNewFeedback(boolean onlyNewFeedback) {
    this.onlyNewFeedback = onlyNewFeedback;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap fields = super.getFields();

    fields.put("title", title);
    fields.put("category", category);
    fields.put("date_check", dateCheck);
    fields.put("pin", pin);
    fields.put("tags", tags);
    fields.put("status", status);
    fields.put("player_id", playerId);
    fields.put("only_new_content", onlyNewContent);
    fields.put("only_new_feedback", onlyNewFeedback);

    return fields;
  }
}
