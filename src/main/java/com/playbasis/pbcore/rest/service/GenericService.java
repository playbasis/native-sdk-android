package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.form.ParamsMap;
import com.playbasis.pbcore.rest.result.generic.GenericApiResult;

import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Tar on 11/2/16.
 */

public interface GenericService {

  @GET
  Observable<GenericApiResult> get(
      @NonNull @Url String url,
      @NonNull @Query("api_key") String apiKey,
      @QueryMap ParamsMap paramsMap);

  @POST
  Observable<GenericApiResult> post(
      @NonNull @Url String url,
      @NonNull @Field("token") String token,
      @FieldMap ParamsMap fields);
}
