package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.result.organize.RemovePlayerFromOrganizeApiResult;
import com.playbasis.pbcore.rest.result.organize.UpdatePlayerOrganizationApiResult;
import com.playbasis.pbcore.rest.result.player.ForgetPasswordApiResult;
import com.playbasis.pbcore.rest.result.player.GetPlayerBadgesApiResult;
import com.playbasis.pbcore.rest.result.player.GetPlayerDetailApiResult;
import com.playbasis.pbcore.rest.result.player.GetPlayerGoodsApiResult;
import com.playbasis.pbcore.rest.result.player.GetUserCustomFieldsApiResult;
import com.playbasis.pbcore.rest.result.player.LoginPlayerApiResult;
import com.playbasis.pbcore.rest.result.player.PlayerJoinedQuestApiResult;
import com.playbasis.pbcore.rest.result.player.PlayerQuestApiResult;
import com.playbasis.pbcore.rest.result.player.PlayerQuestListApiResult;
import com.playbasis.pbcore.rest.result.player.RegisterPlayerApiResult;
import com.playbasis.pbcore.rest.result.player.SetPlayerCustomFieldApiResult;
import com.playbasis.pbcore.rest.result.player.UpdatePlayerDetailApiResult;
import com.playbasis.pbcore.rest.result.player.VerifyPlayerEmailApiResult;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by androiddev01 on 4/26/2016 AD.
 */
public interface PlayerService {

  /**
   * Login the player to the platform
   *
   * @param token    access token
   * @param email    email of the player
   * @param password password of the player
   * @return PlayerResponse api result observable
   */
  @FormUrlEncoded
  @POST("Player/auth")
  Observable<LoginPlayerApiResult> loginPlayer(
      @NonNull @Field("token") String token,
      @Field("email") String email,
      @Field("username") String username,
      @NonNull @Field("password") String password
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
      @NonNull @Field("email") String email
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
  Observable<GetPlayerDetailApiResult> getPlayerDetail(
      @NonNull @Path("id") String playerId,
      @NonNull @Field("token") String token
  );

  /**
   * Register a user from client's website as a Playbasis player.
   *
   * @param playerId   user id, must be unique
   * @param token    access token
   * @param username user name, must be unique
   * @param email    user email, must be unique
   * @param image    url to the user profile image
   * @param password user password
   * @return Register user observable
   */
  @FormUrlEncoded
  @POST("Player/{id}/register")
  Observable<RegisterPlayerApiResult> registerPlayer(
      @NonNull @Path("id") String playerId,
      @NonNull @Field("token") String token,
      @NonNull @Field("username") String username,
      @NonNull @Field("email") String email,
      @Field("image") String image,
      @Field("password") String password,
      @Field("approve_status") String approveStatus
  );

  @FormUrlEncoded
  @POST("Player/{id}/email/verify")
  Observable<VerifyPlayerEmailApiResult> sendPlayerVerifyEmail(
      @NonNull @Path("id") String playerId,
      @NonNull @Field("token") String token
  );

  @FormUrlEncoded
  @POST("Player/{id}/update")
  Observable<UpdatePlayerDetailApiResult> updatePlayer(
      @NonNull @Path("id") String userId,
      @NonNull @Field("token") String token,
      @Field("first_name") String firstName,
      @Field("last_name") String lastName,
      @Field("gender") String gender,
      @Field("birth_date") String birthDate,
      @Field("image") String imageUrl
  );


  @GET("Player/{id}/custom")
  Observable<GetUserCustomFieldsApiResult> getPlayerCustomFields(
      @NonNull @Path("id") String playerId,
      @NonNull @Query("api_key") String apiKey
  );

  @FormUrlEncoded
  @POST("Player/{id}/custom")
  Observable<SetPlayerCustomFieldApiResult> setPlayerCustomFields(
      @NonNull @Path("id") String userId,
      @NonNull @Field("token") String token,
      @NonNull @Field("key") String key,
      @NonNull @Field("value") String value
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

  @GET("Player/{id}/badge")
  Observable<GetPlayerBadgesApiResult> getPlayerEarnedBadges(
      @NonNull @Path("id") String playerId,
      @NonNull @Query("api_key") String apiKey
  );

  @GET("Player/{id}/badgeAll")
  Observable<GetPlayerBadgesApiResult> getPlayerAllBadges(
      @NonNull @Path("id") String playerId,
      @NonNull @Query("api_key") String apiKey
  );

  @GET("Player/{id}/goods")
  Observable<GetPlayerGoodsApiResult> getPlayerAllGoods(
      @NonNull @Path("id") String playerId,
      @NonNull @Query("api_key") String apiKey
  );

  @GET("Player/questAll/{id}")
  Observable<PlayerQuestListApiResult> getAllPlayerQuest(
      @NonNull @Path("id") String PlayerId,
      @NonNull @Query("api_key") String apiKey,
      @NonNull @Query("tags") String tags,
      @NonNull @Query("filter") String filter
  );

  @GET("Player/quest")
  Observable<PlayerJoinedQuestApiResult> getPlayerJoinedQuest(
      @NonNull @Query("api_key") String apiKey,
      @NonNull @Query("player_id") String PlayerId,
      @NonNull @Query("tags") String tags,
      @NonNull @Query("filter") String filter
  );

  @GET("Player/quest/{id}")
  Observable<PlayerQuestApiResult> getPlayerQuestDetail(
      @NonNull @Path("id") String questId,
      @NonNull @Query("api_key") String apiKey,
      @NonNull @Query("player_id") String PlayerId
  );
}
