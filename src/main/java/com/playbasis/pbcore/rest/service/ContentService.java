package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.result.ContentOpinionApiResult;
import com.playbasis.pbcore.rest.result.ContentsApiResult;
import com.playbasis.pbcore.rest.result.CountContentApiResult;
import com.playbasis.pbcore.rest.result.CreateContentApiResult;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by androiddev01 on 5/11/2016 AD.
 */
public interface ContentService {

  @GET("Content")
  Observable<ContentsApiResult> getContents(
      @NonNull @Query("api_key") String apiKey,
      @Query("category") String projectCategory,
      @Query("sort") String sort,
      @Query("order") String order,
      @Query("offset") int offset,
      @Query("limit") int limit,
      @Query("player_id") String playerId,
      @Query("pin") String pin,
      @Query("only_new_content") boolean onlyNewContent
  );

  @GET("Content/count")
  Observable<CountContentApiResult> countContents(
      @NonNull @Query("api_key") String apiKey,
      @Query("category") String category,
      @Query("player_id") String playerId,
      @Query("only_new_content") boolean onlyNewContent
  );

  @FormUrlEncoded
  @POST("Content/{node_id}/player/{user_id}/like")
  Observable<ContentOpinionApiResult> likeContent(
      @NonNull @Field("token") String token,
      @NonNull @Path("node_id") String ideaId,
      @NonNull @Path("user_id") String userId,
      @Field("key") String key,
      @Field("value") String value
  );

  @FormUrlEncoded
  @POST("Content/{node_id}/player/{user_id}/dislike")
  Observable<ContentOpinionApiResult> dislikeContent(
      @NonNull @Field("token") String token,
      @NonNull @Path("node_id") String ideaId,
      @NonNull @Path("user_id") String userId,
      @Field("key") String key,
      @Field("value") String value
  );

  @FormUrlEncoded
  @POST("Content/{node_id}/player/{user_id}/feedback")
  Observable<ContentOpinionApiResult> sendContentFeedback(
      @NonNull @Field("token") String token,
      @NonNull @Path("node_id") String ideaId,
      @NonNull @Path("user_id") String userId,
      @NonNull @Field("feedback") String comment,
      @Field("key") String choice,
      @Field("value") String rating
  );

  /**
   * Send an additional idea to the backend
   *
   * @param token     application token
   * @param title     title of the idea
   * @param summary   summary of the idea
   * @param detail    detail of the idea
   * @param dateStart date of start
   * @param dateEnd   date of end
   * @param status    alway false
   * @return observable
   */
  @FormUrlEncoded
  @POST("Content/addContent")
  Observable<CreateContentApiResult> createContent(
      @NonNull @Field("token") String token,
      @NonNull @Field("title") String title,
      @NonNull @Field("summary") String summary,
      @NonNull @Field("detail") String detail,
      @Field("category") String projectCategory,
      @Field("date_start") String dateStart,
      @Field("date_end") String dateEnd,
      @Field("key") String key,
      @Field("value") String value,
      @Field("image") String image,
      @Field("status") boolean status);
}
