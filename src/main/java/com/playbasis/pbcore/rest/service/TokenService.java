package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.result.RequestTokenApiResult;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface TokenService {

  @FormUrlEncoded
  @POST("Auth")
  Observable<RequestTokenApiResult> getToken(
      @NonNull @Field("api_key") String key,
      @Field("api_secret") String secret
  );

}
