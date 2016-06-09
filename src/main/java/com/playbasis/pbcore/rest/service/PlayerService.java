package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.result.ForgetPasswordApiResult;
import com.playbasis.pbcore.rest.result.GetUserCustomFieldsApiResult;
import com.playbasis.pbcore.rest.result.GetUserDetailApiResult;
import com.playbasis.pbcore.rest.result.LoginPlayerApiResult;
import com.playbasis.pbcore.rest.result.RegisterUserApiResult;
import com.playbasis.pbcore.rest.result.RemovePlayerFromOrganizeApiResult;
import com.playbasis.pbcore.rest.result.SetPlayerCustomFieldApiResult;
import com.playbasis.pbcore.rest.result.UpdatePlayerDetailApiResult;
import com.playbasis.pbcore.rest.result.UpdatePlayerOrganizationApiResult;
import com.playbasis.pbcore.rest.result.VerifyPlayerEmailApiResult;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
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
   * @return getPlayerInfoResponse api result observable
   */
  @FormUrlEncoded
  @POST("Player/auth")
  Observable<LoginPlayerApiResult> loginPlayer(
      @NonNull @Field("token") String token,
      @Field("email") String email,
      @NonNull @Field("password") String password
  );

  /**
   * Send a new password to the getPlayerInfoResponse mail box.
   *
   * @param token access token
   * @param email email of the getPlayerInfoResponse
   * @return forget api result observable
   */
  @FormUrlEncoded
  @POST("Player/password/email")
  Observable<ForgetPasswordApiResult> forgetPlayerPassword(
      @NonNull @Field("token") String token,
      @NonNull @Field("email") String email
  );

  /**
   * Get the details of a getPlayerInfoResponse
   *
   * @param token  access token
   * @param userId getPlayerInfoResponse id
   * @return User info result observable
   */
  @FormUrlEncoded
  @POST("Player/{id}/data/all")
  Observable<GetUserDetailApiResult> getPlayerDetail(
      @NonNull @Field("token") String token,
      @NonNull @Path("id") String userId
  );

  /**
   * Register a user from client's website as a Playbasis player.
   *
   * @param token    access token
   * @param userId   user id, must be unique
   * @param username user name, must be unique
   * @param email    user email, must be unique
   * @param image    url to the user profile image
   * @param password user password
   * @return Register user observable
   */
  @FormUrlEncoded
  @POST("Player/{id}/register")
  Observable<RegisterUserApiResult> registerPlayer(
      @NonNull @Field("token") String token,
      @Path("id") String playerId,
      @NonNull @Field("username") String username,
      @NonNull @Field("email") String email,
      @Field("image") String image,
      @Field("password") String password,
      @Field("approve_status") String approveStatus
  );

  @FormUrlEncoded
  @POST("Player/{id}/email/verify")
  Observable<VerifyPlayerEmailApiResult> sendPlayerVerifyEmail(
      @NonNull @Field("token") String token,
      @NonNull @Path("id") String playerId
  );

  @FormUrlEncoded
  @POST("Player/{id}/update")
  Observable<UpdatePlayerDetailApiResult> updatePlayer(
      @NonNull @Field("token") String token,
      @NonNull @Path("id") String userId,
      @Field("first_name") String firstName,
      @Field("last_name") String lastName,
      @Field("gender") String gender,
      @Field("birth_date") String birthDate,
      @Field("image") String imageUrl
  );


  @GET("Player/{id}/custom")
  Observable<GetUserCustomFieldsApiResult> getPlayerCustomFields(
      @NonNull @Field("api_key") String apiKey,
      @NonNull @Path("id") String playerId
  );

  @FormUrlEncoded
  @POST("Player/{id}/custom")
  Observable<SetPlayerCustomFieldApiResult> setPlayerCustomFields(
      @NonNull @Field("token") String token,
      @NonNull @Path("id") String userId,
      @NonNull @Field("key") String key,
      @NonNull @Field("value") String value
  );

  @FormUrlEncoded
  @POST("StoreOrg/nodes/{node_id}/addPlayer/{id}")
  Observable<UpdatePlayerOrganizationApiResult> addPlayerOrganization(
      @NonNull @Field("token") String token,
      @NonNull @Path("id") String userId,
      @NonNull @Path("node_id") String organizeId
  );

  @FormUrlEncoded
  @POST("StoreOrg/nodes/{node_id}/removePlayer/{id}")
  Observable<RemovePlayerFromOrganizeApiResult> removePlayerOrganization(
      @NonNull @Field("token") String token,
      @NonNull @Path("id") String userId,
      @NonNull @Path("node_id") String organizeId
  );
}
