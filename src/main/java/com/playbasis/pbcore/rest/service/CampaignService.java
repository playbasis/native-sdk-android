package com.playbasis.pbcore.rest.service;

import android.support.annotation.NonNull;

import com.playbasis.pbcore.rest.result.campaign.RetrieveCampaignApiResult;
import com.playbasis.pbcore.rest.result.game.RetrieveActiveCampaignApiResult;
import com.playbasis.pbcore.rest.result.game.RetrieveGameSettingApiResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Tar on 5/4/16 AD.
 */
public interface CampaignService {

  @GET("Campaign")
  Observable<RetrieveCampaignApiResult> retrieveCampaign(
      @NonNull @Query("api_key") String apiKey,
      @NonNull @Query("campaign_name") String gameName);


}
