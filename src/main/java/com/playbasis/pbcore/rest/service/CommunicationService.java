package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.form.ParamsMap;
import com.playbasis.pbcore.rest.result.communication.SendEmailApiResult;
import com.playbasis.pbcore.rest.result.communication.SendEmailCouponApiResult;

import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Tar on 5/4/16 AD.
 */
public interface CommunicationService {

  @FormUrlEncoded
  @POST("Email/send")
  Observable<SendEmailApiResult> sendEmail(
      @NonNull @Field("token") String token,
      @NonNull @Field("player_id") String playerId,
      @NonNull @Field("subject") String subject,
      @NonNull @Field("message") String message,
      @FieldMap ParamsMap fields
  );

  @FormUrlEncoded
  @POST("Email/goods")
  Observable<SendEmailCouponApiResult> sendEmailCoupon(
      @NonNull @Field("token") String token,
      @NonNull @Field("player_id") String playerId,
      @NonNull @Field("subject") String subject,
      @NonNull @Field("ref_id") String refId,
      @FieldMap ParamsMap fields
  );
}
