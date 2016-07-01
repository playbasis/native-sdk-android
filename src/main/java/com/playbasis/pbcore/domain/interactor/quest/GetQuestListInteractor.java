package com.playbasis.pbcore.domain.interactor.quest;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Quest;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.quest.GetQuestListForm;
import com.playbasis.pbcore.rest.result.quest.QuestListApiResult;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetQuestListInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetQuestListInteractor";

  private GetQuestListForm getQuestListForm;

  @Inject
  public GetQuestListInteractor(ThreadExecutor threadExecutor,
                                PostExecutionThread postExecutionThread,
                                RestClient restClient,
                                RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getQuestService()
        .getAllQuest(
            getApiKey(),
            getQuestListForm.getTags()
        )
        .map(new PBApiErrorCheckFunc<QuestListApiResult>());
  }

  public void setGetQuestListForm(GetQuestListForm getQuestListForm) {
    this.getQuestListForm = getQuestListForm;
  }

  public Func1<QuestListApiResult, List<? extends Quest>> getResultMapFunction() {
    return new Func1<QuestListApiResult, List<? extends Quest>>() {
      @Override
      public List<? extends Quest> call(QuestListApiResult questListApiResult) {
        return Quest.createQuests(questListApiResult.getQuestResponses());
      }
    };
  }
}
