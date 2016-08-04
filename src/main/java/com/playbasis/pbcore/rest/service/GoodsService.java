package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.form.ParamsMap;
import com.playbasis.pbcore.rest.result.goods.GoodsInfoApiResult;
import com.playbasis.pbcore.rest.result.goods.GoodsListApiResult;
import com.playbasis.pbcore.rest.result.goods.RedeemGoodsCouponApiResult;
import com.playbasis.pbcore.rest.result.goods.VerifyGoodsCouponApiResult;

import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Tar on 5/4/16 AD.
 */
public interface GoodsService {

  @GET("Goods")
  Observable<GoodsListApiResult> getGoods(
      @NonNull @Query("api_key") String apiKey,
      @NonNull @Query("player_id") String playerId,
      @QueryMap ParamsMap params
  );

  @GET("Goods/{goods_id}")
  Observable<GoodsInfoApiResult> getGoodsDetail(
      @NonNull @Path("goods_id") String goodsId,
      @NonNull @Query("api_key") String apiKey,
      @QueryMap ParamsMap params
  );

  @GET("Goods/couponVerify")
  Observable<VerifyGoodsCouponApiResult> verifyGoodsCoupon(
      @NonNull @Query("api_key") String apiKey,
      @NonNull @Query("goods_id") String goodsId,
      @NonNull @Query("coupon_code") String couponCode,
      @QueryMap ParamsMap params
  );

  /**
   * Get the details of a PlayerResponse
   *
   * @param token  access token
   * @param playerId PlayerResponse id
   * @return User info result observable
   */
  @FormUrlEncoded
  @POST("Goods/couponVerify")
  Observable<RedeemGoodsCouponApiResult> redeemGoodsCoupon(
      @NonNull @Field("token") String token,
      @NonNull @Field("goods_id") String goodsId,
      @NonNull @Field("coupon_code") String couponCode,
      @NonNull @Field("player_id") String playerId,
      @FieldMap ParamsMap fields
  );
}
