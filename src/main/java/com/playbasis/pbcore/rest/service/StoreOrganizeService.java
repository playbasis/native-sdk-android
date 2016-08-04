package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.form.ParamsMap;
import com.playbasis.pbcore.rest.result.organize.RemovePlayerFromOrganizeApiResult;
import com.playbasis.pbcore.rest.result.organize.StoreOrganizeApiResult;
import com.playbasis.pbcore.rest.result.organize.UpdatePlayerOrganizationApiResult;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface StoreOrganizeService {

  @GET("StoreOrg/nodes")
  Observable<StoreOrganizeApiResult> getStoreOrganize(
    @NonNull @Query("api_key") String apiKey,
    @QueryMap ParamsMap params
  );

  @FormUrlEncoded
  @POST("StoreOrg/nodes/{node_id}/addPlayer/{id}")
  Observable<UpdatePlayerOrganizationApiResult> addPlayerOrganization(
      @NonNull @Path("id") String userId,
      @NonNull @Path("node_id") String organizeId,
      @NonNull @Field("token") String token
  );

  @FormUrlEncoded
  @POST("StoreOrg/nodes/{node_id}/removePlayer/{id}")
  Observable<RemovePlayerFromOrganizeApiResult> removePlayerOrganization(
      @NonNull @Path("id") String userId,
      @NonNull @Path("node_id") String organizeId,
      @NonNull @Field("token") String token
  );
}
