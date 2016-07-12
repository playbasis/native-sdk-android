package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Quest;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.GetPlayerAllQuestListForm;
import com.playbasis.pbcore.rest.result.player.PlayerQuestListApiResult;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetPlayerAllQuestInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetPlayerAllQuestInteractor";

  protected GetPlayerAllQuestListForm getPlayerAllQuestListForm;

  @Inject
  public GetPlayerAllQuestInteractor(ThreadExecutor threadExecutor,
                                     PostExecutionThread postExecutionThread,
                                     RestClient restClient,
                                     RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .getAllPlayerQuest(
            getPlayerAllQuestListForm.getPlayerId(),
            getApiKey(),
            getPlayerAllQuestListForm.getTags(),
            getPlayerAllQuestListForm.getFilter()
        )
        .map(new PBApiErrorCheckFunc<PlayerQuestListApiResult>())
        .map(getResultMapFunction());
  }

  public void setGetPlayerAllQuestListForm(GetPlayerAllQuestListForm getPlayerAllQuestListForm) {
    this.getPlayerAllQuestListForm = getPlayerAllQuestListForm;
  }

  public Func1<PlayerQuestListApiResult, List<? extends Quest>> getResultMapFunction() {
    return new Func1<PlayerQuestListApiResult, List<? extends Quest>>() {
      @Override
      public List<? extends Quest> call(PlayerQuestListApiResult playerQuestListApiResult) {
        return Quest.createQuests(playerQuestListApiResult.getPlayerQuestResponses());
      }
    };
  }
}
