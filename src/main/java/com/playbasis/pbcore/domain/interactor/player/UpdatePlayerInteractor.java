package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.UpdatePlayerForm;
import com.playbasis.pbcore.rest.result.player.UpdatePlayerDetailApiResult;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class UpdatePlayerInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "UpdatePlayerInteractor";

  protected UpdatePlayerForm form;

  @Inject
  public UpdatePlayerInteractor(PBThreadExecutor threadExecutor,
                                PBPostExecutionThread postExecutionThread,
                                RestClient restClient,
                                RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .updatePlayer(
            form.getPlayerId(),
            getApiToken(),
            form.getFields()
        ).map(new PBApiErrorCheckFunc<UpdatePlayerDetailApiResult>());
  }

  public void setUpdateUserForm(UpdatePlayerForm updatePlayerForm) {
    this.form = updatePlayerForm;
  }
}
