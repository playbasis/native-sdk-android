package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.form.ParamsMap;
import com.playbasis.pbcore.rest.result.player.ActionReportApiResult;
import com.playbasis.pbcore.rest.result.player.ForgetPasswordApiResult;
import com.playbasis.pbcore.rest.result.player.GetPlayerBadgesApiResult;
import com.playbasis.pbcore.rest.result.player.GetPlayerDetailApiResult;
import com.playbasis.pbcore.rest.result.player.GetPlayerGoodsApiResult;
import com.playbasis.pbcore.rest.result.player.GetUserCustomFieldsApiResult;
import com.playbasis.pbcore.rest.result.player.LoginPlayerApiResult;
import com.playbasis.pbcore.rest.result.player.PlayerActionCountApiResult;
import com.playbasis.pbcore.rest.result.player.PlayerJoinedQuestApiResult;
import com.playbasis.pbcore.rest.result.player.PlayerPointApiResult;
import com.playbasis.pbcore.rest.result.player.PlayerPointsApiResult;
import com.playbasis.pbcore.rest.result.player.PlayerQuestApiResult;
import com.playbasis.pbcore.rest.result.player.PlayerQuestListApiResult;
import com.playbasis.pbcore.rest.result.player.PlayerRankApiResult;
import com.playbasis.pbcore.rest.result.player.ReferralCodeApiResult;
import com.playbasis.pbcore.rest.result.player.RegisterPlayerApiResult;
import com.playbasis.pbcore.rest.result.player.RequestOTPCodeApiResult;
import com.playbasis.pbcore.rest.result.player.SetupPhoneApiResult;
import com.playbasis.pbcore.rest.result.player.SetPlayerCustomFieldApiResult;
import com.playbasis.pbcore.rest.result.player.UpdatePlayerDetailApiResult;
import com.playbasis.pbcore.rest.result.player.VerifyOTPCodeApiResult;
import com.playbasis.pbcore.rest.result.player.VerifyPlayerEmailApiResult;

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
 * Created by androiddev01 on 4/26/2016 AD.
 */
public interface PlayerService {

  /**
   * Login the player to the platform
   *
   * @param token    access token
   * @param password password of the player
   * @return PlayerResponse api result observable
   */
  @FormUrlEncoded
  @POST("Player/auth")
  Observable<LoginPlayerApiResult> loginPlayer(
      @NonNull @Field("token") String token,
      @NonNull @Field("password") String password,
      @FieldMap ParamsMap fields
  );

  /**
   * Send a new password to the PlayerResponse mail box.
   *
   * @param token access token
   * @param email email of the PlayerResponse
   * @return forget api result observable
   */
  @FormUrlEncoded
  @POST("Player/password/email")
  Observable<ForgetPasswordApiResult> forgetPlayerPassword(
      @NonNull @Field("token") String token,
      @NonNull @Field("email") String email,
      @FieldMap ParamsMap fields
      );

  /**
   * Get the details of a PlayerResponse
   *
   * @param token  access token
   * @param playerId PlayerResponse id
   * @return User info result observable
   */
  @FormUrlEncoded
  @POST("Player/{id}/data/all")
  Observable<GetPlayerDetailApiResult> getPlayerPrivateInfo(
      @NonNull @Path(value = "id", encoded = true) String playerId,
      @NonNull @Field("token") String token,
      @FieldMap ParamsMap fields
  );

  /**
   * Register a user from client's website as a Playbasis player.
   *
   * @param playerId   user id, must be unique
   * @param token    access token
   * @param username user name, must be unique
   * @param email    user email, must be unique
   * @return Register user observable
   */
  @FormUrlEncoded
  @POST("Player/{id}/register")
  Observable<RegisterPlayerApiResult> registerPlayer(
      @NonNull @Path(value = "id", encoded = true) String playerId,
      @NonNull @Field("token") String token,
      @NonNull @Field("username") String username,
      @NonNull @Field("email") String email,
      @FieldMap ParamsMap fields
  );

  @FormUrlEncoded
  @POST("Player/{id}/email/verify")
  Observable<VerifyPlayerEmailApiResult> sendPlayerVerifyEmail(
      @NonNull @Path(value = "id", encoded = true) String playerId,
      @NonNull @Field("token") String token,
      @FieldMap ParamsMap fields
  );

  @FormUrlEncoded
  @POST("Player/{id}/update")
  Observable<UpdatePlayerDetailApiResult> updatePlayer(
      @NonNull @Path("id") String userId,
      @NonNull @Field("token") String token,
      @FieldMap ParamsMap fields
  );


  @GET("Player/{id}/custom")
  Observable<GetUserCustomFieldsApiResult> getPlayerCustomFields(
      @NonNull @Path(value = "id", encoded = true) String playerId,
      @NonNull @Query("api_key") String apiKey,
      @QueryMap ParamsMap params
  );

  @FormUrlEncoded
  @POST("Player/{id}/custom")
  Observable<SetPlayerCustomFieldApiResult> setPlayerCustomFields(
      @NonNull @Path("id") String userId,
      @NonNull @Field("token") String token,
      @NonNull @Field("key") String key,
      @NonNull @Field("value") String value,
      @FieldMap ParamsMap fields
  );

  @GET("Player/{id}/badge")
  Observable<GetPlayerBadgesApiResult> getPlayerEarnedBadges(
      @NonNull @Path(value = "id", encoded = true) String playerId,
      @NonNull @Query("api_key") String apiKey,
      @QueryMap ParamsMap params
  );

  @GET("Player/{id}/badgeAll")
  Observable<GetPlayerBadgesApiResult> getPlayerAllBadges(
      @NonNull @Path(value = "id", encoded = true) String playerId,
      @NonNull @Query("api_key") String apiKey,
      @QueryMap ParamsMap params
  );

  @GET("Player/{id}/goods")
  Observable<GetPlayerGoodsApiResult> getPlayerAllGoods(
      @NonNull @Path(value = "id", encoded = true) String playerId,
      @NonNull @Query("api_key") String apiKey,
      @QueryMap ParamsMap params
  );

  @GET("Player/questAll/{id}")
  Observable<PlayerQuestListApiResult> getAllPlayerQuest(
      @NonNull @Path(value = "id", encoded = true) String playerId,
      @NonNull @Query("api_key") String apiKey,
      @QueryMap  ParamsMap fields
  );

  @GET("Player/quest")
  Observable<PlayerJoinedQuestApiResult> getPlayerJoinedQuest(
      @NonNull @Query("api_key") String apiKey,
      @NonNull @Query("player_id") String PlayerId,
      @QueryMap ParamsMap params
  );

  @GET("Player/quest/{id}")
  Observable<PlayerQuestApiResult> getPlayerQuestDetail(
      @NonNull @Path("id") String questId,
      @NonNull @Query("api_key") String apiKey,
      @NonNull @Query("player_id") String playerId,
      @QueryMap ParamsMap params
  );

  @GET("Player/{id}/points")
  Observable<PlayerPointsApiResult> getPlayerAllPoints(
      @NonNull @Path(value = "id", encoded = true) String playerId,
      @NonNull @Query("api_key") String apiKey,
      @QueryMap ParamsMap params
  );

  @GET("Player/{id}/points/{point_name}")
  Observable<PlayerPointApiResult> getPlayerPoint(
      @NonNull @Path(value = "id", encoded = true) String playerId,
      @NonNull @Path("point_name") String pointName,
      @NonNull @Query("api_key") String apiKey,
      @QueryMap ParamsMap params
  );

  @GET("Player/rank/{rank_by}/{limit}")
  Observable<PlayerRankApiResult> getPlayerRanking(
      @NonNull @Path("rank_by") String rankBy,
      @NonNull @Path("limit") int limit,
      @NonNull @Query("api_key") String apiKey,
      @QueryMap ParamsMap params
  );

  @FormUrlEncoded
  @POST("Player/auth/{id}/requestOTPCode")
  Observable<RequestOTPCodeApiResult> requestOTPCode(
      @NonNull @Path(value = "id", encoded = true) String playerId,
      @NonNull @Field("token") String token,
      @FieldMap ParamsMap fields
  );

  @FormUrlEncoded
  @POST("Player/auth/{id}/setupPhone")
  Observable<SetupPhoneApiResult> setupPhone(
      @NonNull @Path(value = "id", encoded = true) String playerId,
      @NonNull @Field("token") String token,
      @NonNull @Field("phone_number") String phoneNumber,
      @FieldMap ParamsMap fields
  );

  @FormUrlEncoded
  @POST("Player/auth/{id}/verifyOTPCode")
  Observable<VerifyOTPCodeApiResult> verifyOTPCode(
      @NonNull @Path(value = "id", encoded = true) String playerId,
      @NonNull @Field("token") String token,
      @NonNull @Field("code") String code,
      @FieldMap ParamsMap fields
  );

  @GET("Player/{id}/actionReport")
  Observable<ActionReportApiResult> actionReport(
      @NonNull @Path(value = "id", encoded = true) String playerId,
      @NonNull @Query("api_key") String apiKey,
      @QueryMap ParamsMap params
  );

  @GET("Player/{id}/code")
  Observable<ReferralCodeApiResult> referralCode(
      @NonNull @Path(value = "id", encoded = true) String playerId,
      @NonNull @Query("api_key") String apiKey,
      @QueryMap ParamsMap params
  );

  @GET("Player/{id}/action/{actionName}/count")
  Observable<PlayerActionCountApiResult> actionCount(
      @NonNull @Path(value = "id", encoded = true) String playerId,
      @NonNull @Path("actionName") String actionName,
      @NonNull @Query("api_key") String apiKey,
      @QueryMap ParamsMap params
  );
}
