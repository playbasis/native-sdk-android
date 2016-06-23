package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.CancelQuestForm;
import com.playbasis.pbcore.rest.result.CancelQuestApiResult;
import com.playbasis.pbcore.rest.result.function.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class CancelQuestInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetIdeasInteractor";

  private CancelQuestForm joinQuestForm;

  @Inject
  public CancelQuestInteractor(ThreadExecutor threadExecutor,
                               PostExecutionThread postExecutionThread,
                               RestClient restClient,
                               RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getQuestService()
        .cancelQuest(
            joinQuestForm.getQuestId(),
            getApiToken(),
            joinQuestForm.getPlayerId()
        )
        .map(new PBApiErrorCheckFunc<CancelQuestApiResult>());
  }

  public void setCancelQuestForm(CancelQuestForm joinQuestForm) {
    this.joinQuestForm = joinQuestForm;
  }
}
