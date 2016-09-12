package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.result.player.ActionReportApiResult;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Tar on 8/31/16 AD.
 */
public class ActionReport extends PBModel {

  protected String year;
  protected String month;
  protected double quantity;
  protected double previousQuantity;
  protected double percentChanged;

  public ActionReport(String year, String month, ActionReportApiResult.Response response) {
    this.year = year;
    this.month = month;
    this.quantity = response.quantity;
    this.previousQuantity = response.previousQuantity;
    this.percentChanged = response.percentChanged;
  }

  public static ArrayList<ActionReport> createActionReport(HashMap<String, HashMap<String, ActionReportApiResult.Response>> yearMap) {
    ArrayList<ActionReport> actionReports = new ArrayList<>();

    if (yearMap != null) {
      for (String year : yearMap.keySet()) {
        HashMap<String, ActionReportApiResult.Response> monthMap = yearMap.get(year);
        for (String month : monthMap.keySet()) {
          actionReports.add(new ActionReport(year, month, monthMap.get(month)));
        }
      }
    }

    return actionReports;
  }

  public String getYear() {
    return year;
  }

  public String getMonth() {
    return month;
  }

  public double getQuantity() {
    return quantity;
  }

  public double getPreviousQuantity() {
    return previousQuantity;
  }

  public double getPercentChanged() {
    return percentChanged;
  }
}
