package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.form.ParamsMap;
import com.playbasis.pbcore.rest.result.Link.GenerateLinkApiResult;

import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Tar on 5/4/16 AD.
 */
public interface LinkService {

  @FormUrlEncoded
  @POST("Link/generate")
  Observable<GenerateLinkApiResult> generate(
      @NonNull @Field("token") String token,
      @FieldMap ParamsMap fields
  );
}
