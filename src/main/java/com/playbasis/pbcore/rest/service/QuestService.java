package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.result.CancelQuestApiResult;
import com.playbasis.pbcore.rest.result.JoinQuestApiResult;
import com.playbasis.pbcore.rest.result.MissionApiResult;
import com.playbasis.pbcore.rest.result.QuestApiResult;
import com.playbasis.pbcore.rest.result.QuestListApiResult;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface QuestService {

  @GET("Quest")
  Observable<QuestListApiResult> getAllQuest(
      @NonNull @Query("api_key") String apiKey,
      @NonNull @Query("tags") String tags
  );

  @GET("Quest/{id}")
  Observable<QuestApiResult> getQuestDetail(
      @NonNull @Path("id") String questId,
      @NonNull @Query("api_key") String apiKey
  );

  @GET("Quest/{quest_id}/mission/{mission_id}")
  Observable<MissionApiResult> getMissionDetail(
      @NonNull @Path("quest_id") String questId,
      @NonNull @Path("mission_id") String missionId,
      @NonNull @Query("api_key") String apiKey
  );

  @FormUrlEncoded
  @POST("Quest/{id}/join")
  Observable<JoinQuestApiResult> joinQuest(
      @NonNull @Path("id") String questId,
      @NonNull @Field("token") String token,
      @NonNull @Field("player_id") String playerId
  );

  @FormUrlEncoded
  @POST("Quest/{id}/cancel")
  Observable<CancelQuestApiResult> cancelQuest(
      @NonNull @Path("id") String questId,
      @NonNull @Field("token") String token,
      @NonNull @Field("player_id") String playerId
  );

}
