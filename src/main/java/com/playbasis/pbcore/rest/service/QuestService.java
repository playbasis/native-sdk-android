package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.result.quest.CancelQuestApiResult;
import com.playbasis.pbcore.rest.result.quest.JoinQuestApiResult;
import com.playbasis.pbcore.rest.result.quest.MissionInfoApiResult;
import com.playbasis.pbcore.rest.result.quest.QuestInfoApiResult;
import com.playbasis.pbcore.rest.result.quest.QuestLeaderboardApiResult;
import com.playbasis.pbcore.rest.result.quest.QuestListApiResult;

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
  Observable<QuestInfoApiResult> getQuestDetail(
      @NonNull @Path("id") String questId,
      @NonNull @Query("api_key") String apiKey
  );

  @GET("Quest/{quest_id}/mission/{mission_id}")
  Observable<MissionInfoApiResult> getMissionDetail(
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

  @GET("Quest/leader")
  Observable<QuestLeaderboardApiResult> getLeaderboard(
      @NonNull @Query("api_key") String apiKey,
      @NonNull @Query("quest_id") String questId,
      @NonNull @Query("completion_element_id") String completionElementId,
      @Query("limit") int limit,
      @Query("offset") int offset,
      @Query("status") String status,
      @Query("player_id") String playerId
  );
}
