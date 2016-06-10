package com.playbasis.pbcore.rest.form;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class GetContentsForm extends PBForm {
  public static final String TAG = "GetContentsForm";

  public String category = null;
  public String sort = null;
  public String order = null;
  public int limit = 10;
  public int offset = 0;
  public String playerId = null;
  public String pin = null;
  public boolean onlyNewContents = false;

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
}
