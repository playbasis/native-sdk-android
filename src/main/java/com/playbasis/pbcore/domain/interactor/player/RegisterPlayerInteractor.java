package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.PlayerRegistrationForm;
import com.playbasis.pbcore.rest.result.player.RegisterPlayerApiResult;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class RegisterPlayerInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "RegisterPlayerInteractor";

  protected PlayerRegistrationForm playerRegistrationForm;

  @Inject
  public RegisterPlayerInteractor(PBThreadExecutor threadExecutor,
                                  PBPostExecutionThread postExecutionThread,
                                  RestClient restClient,
                                  RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .registerPlayer(
            playerRegistrationForm.getPlayerId(),
            getApiToken(),
            playerRegistrationForm.getUserName(),
            playerRegistrationForm.getEmail(),
            playerRegistrationForm.getFields()
        ).map(new PBApiErrorCheckFunc<RegisterPlayerApiResult>());
  }

  public void setPlayerRegistrationForm(PlayerRegistrationForm playerRegistrationForm) {
    this.playerRegistrationForm = playerRegistrationForm;
  }
}
