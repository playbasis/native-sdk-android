package com.playbasis.pbcore.rest.result.setting;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.PBApiResult;

import java.util.Date;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class AppStatusApiResult extends PBApiResult<AppStatusApiResult.Response> {

  public AppPeriodResponse getAppPeriodResponse() {
    if (response != null) {
      return response.appPeriodResponse;
    }

    return null;
  }

  public class Response {

    @SerializedName("app_status")
    public boolean appStatus;
    @SerializedName("app_period")
    public AppPeriodResponse appPeriodResponse;
  }

  public class AppPeriodResponse {
    @SerializedName("date_start")
    public Date dateStart;
    @SerializedName("date_end")
    public Date dateEnd;
  }
}
