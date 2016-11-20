package com.playbasis.pbcore.domain.interactor.game;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Campaign;
import com.playbasis.pbcore.domain.model.GameSetting;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.game.RetrieveActiveCampaignForm;
import com.playbasis.pbcore.rest.result.game.RetrieveActiveCampaignApiResult;
import com.playbasis.pbcore.rest.result.game.RetrieveGameSettingApiResult;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Nott on 17/11/2559.
 * DBS-SDK
 */

public class GetActiveCampaignInteractor extends PlayBasisApiInteractor {
  private static final String TAG = "GetGameSetting";

  private RetrieveActiveCampaignForm retrieveActiveCampaignForm;

  @Inject
  public GetActiveCampaignInteractor(PBThreadExecutor threadExecutor,
                                     PBPostExecutionThread postExecutionThread,
                                     RestClient restClient,
                                     RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getGameService().getActiveCampaign(getApiKey(),
        retrieveActiveCampaignForm.getGameName())
        .map(new PBApiErrorCheckFunc<RetrieveActiveCampaignApiResult>())
        .map(getResultMapFunction());
  }

  public void setForm(RetrieveActiveCampaignForm retrieveGameSettingsForm) {
    this.retrieveActiveCampaignForm = retrieveGameSettingsForm;
  }

  public Func1<RetrieveActiveCampaignApiResult, Campaign> getResultMapFunction() {
    return new Func1<RetrieveActiveCampaignApiResult, Campaign>() {
      @Override
      public Campaign call(RetrieveActiveCampaignApiResult response) {
        return new Campaign(response.response.response);
      }
    };
  }
}
