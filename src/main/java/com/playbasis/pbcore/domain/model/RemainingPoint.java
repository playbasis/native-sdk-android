package com.playbasis.pbcore.domain.model;

import android.os.Parcel;

import com.playbasis.pbcore.rest.response.GameStageResponse;
import com.playbasis.pbcore.rest.result.point.RemainingPointApiResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nott on 16/11/2559.
 * playbasis-sdk-android-project
 */

public class RemainingPoint extends PBModel {
  public static final String TAG = "RemainingPoint";

  public String name;
  public String quantity;

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.name);
    dest.writeString(this.quantity);
  }

  public RemainingPoint() {
  }

  public static <T extends RemainingPointApiResult.Response> ArrayList<RemainingPoint> createRemainingPoints(List<T> responses) {
    ArrayList<RemainingPoint> remainingPoints = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return remainingPoints;
    }

    for (T response : responses) {
      remainingPoints.add(new RemainingPoint(response.name, response.quantity));
    }

    return remainingPoints;
  }


  public RemainingPoint(String name, String quantity) {
    this.name = name;
    this.quantity = quantity;
  }

  protected RemainingPoint(Parcel in) {
    this.name = in.readString();
    this.quantity = in.readString();
  }

  public static final Creator<RemainingPoint> CREATOR = new Creator<RemainingPoint>() {
    @Override
    public RemainingPoint createFromParcel(Parcel source) {
      return new RemainingPoint(source);
    }

    @Override
    public RemainingPoint[] newArray(int size) {
      return new RemainingPoint[size];
    }
  };
}
