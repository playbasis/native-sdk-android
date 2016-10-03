package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.form.ParamsMap;
import com.playbasis.pbcore.rest.result.merchant.AvailableBranchForGoodsGroupApiResult;
import com.playbasis.pbcore.rest.result.merchant.RedeemCouponApiResult;
import com.playbasis.pbcore.rest.result.merchant.CouponVerificationApiResult;

import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

  @GET("Merchant/goodsGroup/verify")
  Observable<CouponVerificationApiResult> verifyCoupon(
      @NonNull @Field("api_key") String apiKey,
      @NonNull @Field("goods_group") String goodsGroup,
      @NonNull @Field("coupon_code") String couponCode,
      @QueryMap ParamsMap fields
  );

  @FormUrlEncoded
  @POST("Merchant/goodsGroup/redeem")
  Observable<RedeemCouponApiResult> redeemCoupon(
      @NonNull @Field("token") String token,
      @NonNull @Field("goods_group") String goodsGroup,
      @NonNull @Field("coupon_code") String couponCode,
      @FieldMap ParamsMap fields
  );
}
