package com.playbasis.pbcore.rest.form;

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

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  public String getOrder() {
    return order;
  }

  public void setOrder(String order) {
    this.order = order;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public int getOffset() {
    return offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public String getPlayerId() {
    return playerId;
  }

  public void setPlayerId(String playerId) {
    this.playerId = playerId;
  }

  public String getPin() {
    return pin;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }

  public boolean isOnlyNewContents() {
    return onlyNewContents;
  }

  public void setOnlyNewContents(boolean onlyNewContents) {
    this.onlyNewContents = onlyNewContents;
  }
}
