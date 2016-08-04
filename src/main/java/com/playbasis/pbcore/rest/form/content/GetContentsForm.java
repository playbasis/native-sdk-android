package com.playbasis.pbcore.rest.form.content;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class GetContentsForm extends PBForm {
  public static final String TAG = "GetContentsForm";

  protected String category = null;
  protected String sort = null;
  protected String order = null;
  protected int limit = 10;
  protected int offset = 0;
  protected String playerId = null;
  protected String pin = null;
  protected boolean onlyNewContents = false;
  protected boolean onlyNewFeedbacks = false;

  public GetContentsForm() {

  }

  @Override
  public ParamsMap getFields() {
    ParamsMap fields = super.getFields();

    fields.put("node_id", null);
    fields.put("title", null);
    fields.put("category", category);
    fields.put("date_check", false);
    fields.put("sort", null);
    fields.put("order", "asc");
    fields.put("offset", offset);
    fields.put("limit", limit);
    fields.put("full_html", false);
    fields.put("pin", pin);
    fields.put("tags", null);
    fields.put("status", null);
    fields.put("player_id", playerId);
    fields.put("only_new_content", onlyNewContents);
    fields.put("only_new_feedback", onlyNewFeedbacks);

    return fields;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  public void setOrder(String order) {
    this.order = order;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public void setPlayerId(String playerId) {
    this.playerId = playerId;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }

  public void setOnlyNewContents(boolean onlyNewContents) {
    this.onlyNewContents = onlyNewContents;
  }

  public void setOnlyNewFeedbacks(boolean onlyNewFeedbacks) {
    this.onlyNewFeedbacks = onlyNewFeedbacks;
  }
}
