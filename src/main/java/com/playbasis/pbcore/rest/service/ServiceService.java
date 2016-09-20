package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.form.ParamsMap;
import com.playbasis.pbcore.rest.result.service.RecentActivitiesApiResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Tar on 9/20/16 AD.
 */
public interface ServiceService {

  @GET("Service/recentActivities")
  Observable<RecentActivitiesApiResult> recentActivities(
      @NonNull @Query("api_key") String apiKey,
      @QueryMap ParamsMap params
  );
}
