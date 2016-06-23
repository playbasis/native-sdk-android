package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.result.organize.StoreOrganizeApiResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface StoreOrganizeService {

  @GET("StoreOrg/nodes")
  Observable<StoreOrganizeApiResult> getStoreOrganize(
    @NonNull @Query("api_key") String apiKey,
    @Query("organize_id") String organizeId
  );

}
