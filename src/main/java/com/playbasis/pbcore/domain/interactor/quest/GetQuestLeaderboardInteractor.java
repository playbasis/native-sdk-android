package com.playbasis.pbcore.domain.interactor.quest;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.QuestPlayerRank;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.quest.QuestLeaderboardForm;
import com.playbasis.pbcore.rest.result.quest.QuestLeaderboardApiResult;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetQuestLeaderboardInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetQuestLeaderboardInteractor";

  protected QuestLeaderboardForm questLeaderboardForm;

  @Inject
  public GetQuestLeaderboardInteractor(PBThreadExecutor threadExecutor,
                                       PBPostExecutionThread postExecutionThread,
                                       RestClient restClient,
                                       RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getQuestService()
        .getLeaderboard(
            getApiKey(),
            questLeaderboardForm.getQuestId(),
            questLeaderboardForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<QuestLeaderboardApiResult>())
        .map(getResultMapFunction());
  }

  public void setQuestLeaderboardForm(QuestLeaderboardForm questLeaderboardForm) {
    this.questLeaderboardForm = questLeaderboardForm;
  }

  public Func1<QuestLeaderboardApiResult, List<? extends QuestPlayerRank>> getResultMapFunction() {
    return new Func1<QuestLeaderboardApiResult, List<? extends QuestPlayerRank>>() {
      @Override
      public List<? extends QuestPlayerRank> call(QuestLeaderboardApiResult questLeaderboardApiResult) {
        return QuestPlayerRank.createQuestPlayerRank(questLeaderboardApiResult.getQuestLeaderboardResponses());
      }
    };
  }
}
