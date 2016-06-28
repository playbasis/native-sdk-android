package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.GetPlayerAllQuestListForm;
import com.playbasis.pbcore.rest.result.player.PlayerQuestListApiResult;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetPlayerAllQuestInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetPlayerAllQuestInteractor";

  private GetPlayerAllQuestListForm getPlayerAllQuestListForm;

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
        .map(new PBApiErrorCheckFunc<PlayerQuestListApiResult>());
  }

  public void setGetPlayerAllQuestListForm(GetPlayerAllQuestListForm getPlayerAllQuestListForm) {
    this.getPlayerAllQuestListForm = getPlayerAllQuestListForm;
  }
}
