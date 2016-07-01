package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Quest;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.GetPlayerQuestInfoForm;
import com.playbasis.pbcore.rest.result.player.PlayerQuestApiResult;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetPlayerQuestInfoInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetPlayerAllQuestInteractor";

  private GetPlayerQuestInfoForm getPlayerQuestInfoForm;

  @Inject
  public GetPlayerQuestInfoInteractor(ThreadExecutor threadExecutor,
                                      PostExecutionThread postExecutionThread,
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
            getPlayerQuestInfoForm.getPlayerId()
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
