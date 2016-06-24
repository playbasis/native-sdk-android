package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.GetPlayerJoinedQuestListForm;
import com.playbasis.pbcore.rest.result.player.PlayerJoinedQuestApiResult;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetPlayerJoinedQuestInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetPlayerJoinedQuestInteractor";

  private GetPlayerJoinedQuestListForm getPlayerJoinedQuestListForm;

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
            getPlayerJoinedQuestListForm.getTags(),
            getPlayerJoinedQuestListForm.getFilter()
        )
        .map(new PBApiErrorCheckFunc<PlayerJoinedQuestApiResult>());
  }

  public void setGetPlayerJoinedQuestListForm(GetPlayerJoinedQuestListForm getPlayerJoinedQuestListForm) {
    this.getPlayerJoinedQuestListForm = getPlayerJoinedQuestListForm;
  }
}
