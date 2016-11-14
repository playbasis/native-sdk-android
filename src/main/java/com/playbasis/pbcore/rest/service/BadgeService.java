package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.form.ParamsMap;
import com.playbasis.pbcore.rest.result.badge.AllBadgesApiResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Tar on 5/4/16 AD.
 */
public interface BadgeService {

  @GET("Badges")
  Observable<AllBadgesApiResult> getAllBadges(
      @NonNull @Query("api_key") String apiKey,
      @QueryMap ParamsMap params
  );

}
