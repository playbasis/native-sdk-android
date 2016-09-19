package com.playbasis.pbcore.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

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

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.year);
    dest.writeString(this.month);
    dest.writeDouble(this.quantity);
    dest.writeDouble(this.previousQuantity);
    dest.writeDouble(this.percentChanged);
  }

  protected ActionReport(Parcel in) {
    this.year = in.readString();
    this.month = in.readString();
    this.quantity = in.readDouble();
    this.previousQuantity = in.readDouble();
    this.percentChanged = in.readDouble();
  }

  public static final Creator<ActionReport> CREATOR = new Creator<ActionReport>() {
    @Override
    public ActionReport createFromParcel(Parcel source) {
      return new ActionReport(source);
    }

    @Override
    public ActionReport[] newArray(int size) {
      return new ActionReport[size];
    }
  };
}
