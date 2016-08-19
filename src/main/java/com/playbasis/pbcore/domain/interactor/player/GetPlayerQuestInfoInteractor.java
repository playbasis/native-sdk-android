package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Quest;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.GetPlayerQuestInfoForm;
import com.playbasis.pbcore.rest.result.player.PlayerQuestApiResult;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetPlayerQuestInfoInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetPlayerAllQuestInteractor";

  protected GetPlayerQuestInfoForm getPlayerQuestInfoForm;

  @Inject
  public GetPlayerQuestInfoInteractor(PBThreadExecutor threadExecutor,
                                      PBPostExecutionThread postExecutionThread,
                                      RestClient restClient,
                                      RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .getPlayerQuestDetail(
            getPlayerQuestInfoForm.getQuestId(),
            getApiKey(),
            getPlayerQuestInfoForm.getPlayerId(),
            getPlayerQuestInfoForm.getFields()

        )
        .map(new PBApiErrorCheckFunc<PlayerQuestApiResult>())
        .map(getResultMapFunction());
  }

  public void setGetPlayerQuestInfoForm(GetPlayerQuestInfoForm getPlayerQuestInfoForm) {
    this.getPlayerQuestInfoForm = getPlayerQuestInfoForm;
  }

  public Func1<PlayerQuestApiResult, ? extends Quest> getResultMapFunction() {
    return new Func1<PlayerQuestApiResult, Quest>() {
      @Override
      public Quest call(PlayerQuestApiResult playerQuestApiResult) {
        return new Quest(playerQuestApiResult.getPlayerQuestResponse());
      }
    };
  }
}
