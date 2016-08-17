package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.form.ParamsMap;
import com.playbasis.pbcore.rest.result.redeem.RedeemGoodsApiResult;
import com.playbasis.pbcore.rest.result.redeem.RedeemGoodsGroupApiResult;

import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Tar on 8/17/16 AD.
 */
public interface RedeemService {

  @FormUrlEncoded
  @POST("Redeem/goods")
  Observable<RedeemGoodsApiResult> redeemGoods(
      @NonNull @Field("token") String token,
      @NonNull @Field("player_id") String playerId,
      @NonNull @Field("goods_id") String goodsId,
      @FieldMap ParamsMap fields
  );

  @FormUrlEncoded
  @POST("Redeem/goodsGroup")
  Observable<RedeemGoodsGroupApiResult> redeemGoodsGroup(
      @NonNull @Field("token") String token,
      @NonNull @Field("player_id") String playerId,
      @NonNull @Field("group") String group,
      @FieldMap ParamsMap fields
  );
}
