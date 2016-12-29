package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.form.ParamsMap;
import com.playbasis.pbcore.rest.result.Engine.RuleApiResult;

import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Tar on 5/4/16 AD.
 */
public interface EngineService {

  @FormUrlEncoded
  @POST("Engine/rule")
  Observable<RuleApiResult> rule(
      @NonNull @Field("token") String token,
      @NonNull @Field("action") String action,
      @NonNull @Field("player_id") String playerId,
      @FieldMap ParamsMap fields
  );
}
