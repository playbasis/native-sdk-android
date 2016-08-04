package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.form.ParamsMap;
import com.playbasis.pbcore.rest.result.content.ContentOpinionApiResult;
import com.playbasis.pbcore.rest.result.content.ContentsApiResult;
import com.playbasis.pbcore.rest.result.content.CountContentApiResult;
import com.playbasis.pbcore.rest.result.content.CreateContentApiResult;

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
 * Created by androiddev01 on 5/11/2016 AD.
 */
public interface ContentService {

  @GET("Content")
  Observable<ContentsApiResult> getContents(
      @NonNull @Query("api_key") String apiKey,
      @QueryMap ParamsMap params
  );

  @GET("Content/count")
  Observable<CountContentApiResult> countContents(
      @NonNull @Query("api_key") String apiKey,
      @QueryMap ParamsMap params
  );

  @FormUrlEncoded
  @POST("Content/{node_id}/player/{user_id}/like")
  Observable<ContentOpinionApiResult> likeContent(
      @NonNull @Field("token") String token,
      @NonNull @Path("node_id") String ideaId,
      @NonNull @Path("user_id") String userId,
      @FieldMap ParamsMap fields
  );

  @FormUrlEncoded
  @POST("Content/{node_id}/player/{user_id}/dislike")
  Observable<ContentOpinionApiResult> dislikeContent(
      @NonNull @Field("token") String token,
      @NonNull @Path("node_id") String ideaId,
      @NonNull @Path("user_id") String userId,
      @FieldMap ParamsMap fields
  );

  @FormUrlEncoded
  @POST("Content/{node_id}/player/{user_id}/feedback")
  Observable<ContentOpinionApiResult> sendContentFeedback(
      @NonNull @Field("token") String token,
      @NonNull @Path("node_id") String ideaId,
      @NonNull @Path("user_id") String userId,
      @NonNull @Field("feedback") String comment,
      @FieldMap ParamsMap fields
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
      @FieldMap ParamsMap fields
  );
}
