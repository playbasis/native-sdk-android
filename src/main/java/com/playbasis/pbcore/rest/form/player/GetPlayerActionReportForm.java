package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 8/31/16 AD.
 */
public class GetPlayerActionReportForm extends PBForm {

  private String playerId;
  private String month;
  private String year;
  private String action;
  private String parameter;
  private int count = -1;

  public GetPlayerActionReportForm(String playerId) {
    this.playerId = playerId;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("month", month);
    map.put("year", year);
    map.put("action", action);
    map.put("parameter", parameter);

    if (count != -1) {
      map.put("count", count);
    }

    return map;
  }

  public String getPlayerId() {
    return playerId;
  }

  public String getMonth() {
    return month;
  }

  public String getYear() {
    return year;
  }

  public String getAction() {
    return action;
  }

  public String getParameter() {
    return parameter;
  }

  public int getCount() {
    return count;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public void setParameter(String parameter) {
    this.parameter = parameter;
  }

  public void setCount(int count) {
    this.count = count;
  }
}
