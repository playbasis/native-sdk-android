package com.playbasis.pbcore.rest.form.communication;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 8/25/16 AD.
 */
public class SendEmailForm extends PBForm {

  protected String subject;
  protected String playerId;
  protected String message;
  protected String templateId = null;

  public SendEmailForm(String playerId, String subject) {
    this.playerId = playerId;
    this.subject = subject;
    this.message = message;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("template_id", templateId);
    map.put("message", message);

    return map;
  }

  public String getPlayerId() {
    return playerId;
  }

  public String getSubject() {
    return subject;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setTemplateId(String templateId) {
    this.templateId = templateId;
  }
}
