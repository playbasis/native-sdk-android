package com.playbasis.pbcore.rest.form.communication;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 8/25/16 AD.
 */
public class SendEmailCouponForm extends PBForm {

  protected String subject;
  protected String playerId;
  protected String message;
  protected String templateId;
  protected String refId;

  public SendEmailCouponForm(String playerId, String subject, String refId) {
    this.playerId = playerId;
    this.subject = subject;
    this.refId = refId;
  }

  public String getPlayerId() {
    return playerId;
  }

  public String getSubject() {
    return subject;
  }

  public String getRefId() {
    return refId;
  }

  public void setTemplateId(String templateId) {
    this.templateId = templateId;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("message", message);
    map.put("template_id", templateId);

    return map;
  }
}
