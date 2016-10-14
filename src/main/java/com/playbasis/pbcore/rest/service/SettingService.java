package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.form.ParamsMap;
import com.playbasis.pbcore.rest.result.setting.AppStatusApiResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Tar on 10/14/16.
 */

public interface SettingService {

  @GET("Setting/appStatus")
  Observable<AppStatusApiResult> getAppStatus(
      @NonNull @Query("api_key") String apiKey,
      @QueryMap ParamsMap params
  );
}
