package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.result.point.RemainingPointApiResult;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Nott on 16/11/2559.
 * playbasis-sdk-android-project
 */

public interface PointService {

  /**
   * Get Remaining Points API
   *
   * @param name query
   * @param apiKey api key
   * @return Remaining Points Services
   */
  @GET("Point/custom/remaining")
  Observable<RemainingPointApiResult> getRemainingPoints(
      @NonNull @Query("name") String name,
      @NonNull @Query("api_key") String apiKey);
}
