package com.playbasis.pbcore.domain.interactor.game;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.GameSetting;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.game.RetrieveGameSettingsForm;
import com.playbasis.pbcore.rest.result.game.RetrieveGameSettingApiResult;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Nott on 17/11/2559.
 * DBS-SDK
 */

public class GetGameSettingInteractor extends PlayBasisApiInteractor {
  private static final String TAG = "GetGameSetting";

  private RetrieveGameSettingsForm retrieveGameSettingsForm;

  @Inject
  public GetGameSettingInteractor(PBThreadExecutor threadExecutor,
                                  PBPostExecutionThread postExecutionThread,
                                  RestClient restClient,
                                  RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getGameService().getGameSettings(getApiKey(),
        retrieveGameSettingsForm.getGameName())
        .map(new PBApiErrorCheckFunc<RetrieveGameSettingApiResult>())
        .map(getResultMapFunction());
  }

  public void setGameSettingsForm(RetrieveGameSettingsForm retrieveGameSettingsForm) {
    this.retrieveGameSettingsForm = retrieveGameSettingsForm;
  }

  public Func1<RetrieveGameSettingApiResult, List<? extends GameSetting>> getResultMapFunction() {
    return new Func1<RetrieveGameSettingApiResult, List<? extends GameSetting>>() {
      @Override
      public List<? extends GameSetting> call(RetrieveGameSettingApiResult playerQuestApiResult) {
        return GameSetting.createGameSettings(playerQuestApiResult.response);
      }
    };
  }
}
