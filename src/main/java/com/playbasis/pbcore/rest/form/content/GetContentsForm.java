package com.playbasis.pbcore.rest.form.content;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;
import com.playbasis.pbcore.helper.Validator;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class GetContentsForm extends PBForm {
  public static final String TAG = "GetContentsForm";

  protected String nodeId = null;
  protected String title = null;
  protected String category = null;
  protected boolean dateCheck = true;
  protected String sort = "title";
  protected String order = "asc";
  protected int offset = 0;
  protected int limit = 20;
  protected boolean fullHtml = false;
  protected String pin = null;
  protected String tags = null;
  protected String status = null;
  protected String playerId = null;
  protected boolean onlyNewContents = false;
  protected boolean onlyNewFeedbacks = false;

  public GetContentsForm() {

  }

  public void setNodeId(String nodeId) {
    this.nodeId = nodeId;
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

  public void setSort(String sort) {
    this.sort = sort;
  }

  public void setOrder(String order) {
    this.order = order;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public void setFullHtml(boolean fullHtml) {
    this.fullHtml = fullHtml;
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

  public void setOnlyNewContents(boolean onlyNewContents) {
    this.onlyNewContents = onlyNewContents;
  }

  public void setOnlyNewFeedbacks(boolean onlyNewFeedbacks) {
    this.onlyNewFeedbacks = onlyNewFeedbacks;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap fields = super.getFields();

    fields.put("node_id", nodeId);
    fields.put("title", title);
    fields.put("category", category);
    fields.put("date_check", dateCheck);
    fields.put("sort", sort);
    fields.put("order", order);
    fields.put("offset", offset);
    fields.put("limit", limit);
    fields.put("full_html", fullHtml);
    fields.put("pin", pin);
    fields.put("tags", tags);
    fields.put("status", status);

    if (Validator.isValid(playerId)) {
      fields.put("player_id", playerId);
      fields.put("only_new_content", onlyNewContents);
      fields.put("only_new_feedback", onlyNewFeedbacks);
    }

    return fields;
  }
}
