package com.playbasis.pbcore.domain.interactor.quest;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Quest;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.quest.GetQuestInfoForm;
import com.playbasis.pbcore.rest.result.quest.QuestInfoApiResult;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetQuestInfoInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetQuestInfoInteractor";

  protected GetQuestInfoForm getQuestInfoForm;

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
            getApiKey(),
            getQuestInfoForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<QuestInfoApiResult>())
        .map(getResultMapFunction());
  }

  public void setGetQuestListForm(GetQuestInfoForm getQuestInfoForm) {
    this.getQuestInfoForm = getQuestInfoForm;
  }

  public Func1<QuestInfoApiResult, ? extends Quest> getResultMapFunction() {
    return new Func1<QuestInfoApiResult, Quest>() {
      @Override
      public Quest call(QuestInfoApiResult playerQuestApiResult) {
        return new Quest(playerQuestApiResult.getQuestResponse());
      }
    };
  }
}
