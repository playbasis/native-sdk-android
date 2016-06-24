package com.playbasis.pbcore.domain.interactor.quest;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.quest.GetQuestInfoForm;
import com.playbasis.pbcore.rest.result.quest.QuestInfoApiResult;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetQuestInfoInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetQuestInfoInteractor";

  private GetQuestInfoForm getQuestInfoForm;

  @Inject
  public GetQuestInfoInteractor(ThreadExecutor threadExecutor,
                                PostExecutionThread postExecutionThread,
                                RestClient restClient,
                                RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getQuestService()
        .getQuestDetail(
            getQuestInfoForm.getQuestId(),
            getApiKey()
        )
        .map(new PBApiErrorCheckFunc<QuestInfoApiResult>());
  }

  public void setGetQuestListForm(GetQuestInfoForm getQuestInfoForm) {
    this.getQuestInfoForm = getQuestInfoForm;
  }
}
