package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Quest;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.GetPlayerJoinedQuestListForm;
import com.playbasis.pbcore.rest.result.player.PlayerJoinedQuestApiResult;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetPlayerJoinedQuestInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetPlayerJoinedQuestInteractor";

  protected GetPlayerJoinedQuestListForm getPlayerJoinedQuestListForm;

  @Inject
  public GetPlayerJoinedQuestInteractor(ThreadExecutor threadExecutor,
                                        PostExecutionThread postExecutionThread,
                                        RestClient restClient,
                                        RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .getPlayerJoinedQuest(
            getApiKey(),
            getPlayerJoinedQuestListForm.getPlayerId(),
            getPlayerJoinedQuestListForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<PlayerJoinedQuestApiResult>())
        .map(getResultMapFunction());
  }

  public void setGetPlayerJoinedQuestListForm(GetPlayerJoinedQuestListForm getPlayerJoinedQuestListForm) {
    this.getPlayerJoinedQuestListForm = getPlayerJoinedQuestListForm;
  }

  public Func1<PlayerJoinedQuestApiResult, List<? extends Quest>> getResultMapFunction() {
    return new Func1<PlayerJoinedQuestApiResult, List<? extends Quest>>() {
      @Override
      public List<? extends Quest> call(PlayerJoinedQuestApiResult playerJoinedQuestApiResult) {
        return Quest.createQuests(playerJoinedQuestApiResult.getPlayerQuestResponse());
      }
    };
  }
}
