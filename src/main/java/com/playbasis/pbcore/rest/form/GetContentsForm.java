package com.playbasis.pbcore.rest.form;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class GetContentsForm extends PBForm {
  public static final String TAG = "GetContentsForm";

  public String category;
  public String sort;
  public String order;
  public int limit;
  public int offset;
  public String tags;
  public String playerId;
  public String pin;
  public boolean onlyNewContents;

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

  public void setTags(String tags) {
    this.tags = tags;
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
}
