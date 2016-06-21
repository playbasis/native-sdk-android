package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.result.GoodsInfoApiResult;
import com.playbasis.pbcore.rest.result.GoodsListApiResult;
import com.playbasis.pbcore.rest.result.VerifyGoodsCouponApiResult;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Tar on 5/4/16 AD.
 */
public interface GoodsService {

  @GET("Goods")
  Observable<GoodsListApiResult> getGoods(
      @NonNull @Query("api_key") String apiKey,
      @NonNull @Query("player_id") String playerId,
      @Query("tags") String tags
  );

  @GET("Goods/{goods_id}")
  Observable<GoodsInfoApiResult> getGoodsDetail(
      @NonNull @Path("goods_id") String goodsId,
      @NonNull @Query("api_key") String apiKey,
      @Query("player_id") String playerId
  );

  /**
   * Get the details of a getPlayerInfoResponse
   *
   * @param token  access token
   * @param playerId getPlayerInfoResponse id
   * @return User info result observable
   */
  @FormUrlEncoded
  @POST("Goods/couponVerify")
  Observable<VerifyGoodsCouponApiResult> verifyGoodsCoupon(
      @NonNull @Field("token") String token,
      @NonNull @Field("goods_id") String goodsId,
      @NonNull @Field("coupon_code") String couponCode
  );
}
