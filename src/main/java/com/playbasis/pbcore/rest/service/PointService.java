package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.result.point.RemainingPointApiResult;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Nott on 16/11/2559.
 * playbasis-sdk-android-project
 */

public interface PointService {


  @FormUrlEncoded
  @GET("Point/custom/remaining")
  Observable<RemainingPointApiResult> getRemainigPoints(
      @NonNull @Field("token") String token);
}
