package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.form.ParamsMap;
import com.playbasis.pbcore.rest.result.merchant.AvailableBranchForGoodsGroupApiResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Tar on 5/4/16 AD.
 */
public interface MerchantService {

  @GET("Merchant/availableBranchGoodsGroup")
  Observable<AvailableBranchForGoodsGroupApiResult> availableBranchGoodsGroup(
      @NonNull @Query("api_key") String apiKey,
      @NonNull @Query("goods_group") String goodsGroup,
      @QueryMap ParamsMap fields
  );
}
