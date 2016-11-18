package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.result.game.RetrieveActiveCampaignApiResult;
import com.playbasis.pbcore.rest.result.game.RetrieveGameSettingApiResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Tar on 5/4/16 AD.
 */
public interface GameService {

  @GET("Game")
  Observable<RetrieveGameSettingApiResult> getGameSettings(
      @NonNull @Query("api_key") String apiKey,
      @NonNull @Query("game_name") String gameName);

  @GET("Game/campaign/active")
  Observable<RetrieveActiveCampaignApiResult> getActiveCampaign(
      @NonNull @Query("api_key") String apiKey,
      @NonNull @Query("game_name") String gameName);

}
