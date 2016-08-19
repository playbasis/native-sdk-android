package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.PlayerEmailVerificationForm;
import com.playbasis.pbcore.rest.result.player.VerifyPlayerEmailApiResult;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class SendPlayerEmailVerificationInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "SendPlayerEmailVerificationInteractor";

  protected PlayerEmailVerificationForm playerEmailVerificationForm;

  @Inject
  public SendPlayerEmailVerificationInteractor(PBThreadExecutor threadExecutor,
                                               PBPostExecutionThread postExecutionThread,
                                               RestClient restClient,
                                               RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .sendPlayerVerifyEmail(
            playerEmailVerificationForm.getPlayerId(),
            getApiToken(),
            playerEmailVerificationForm.getFields()
        ).map(new PBApiErrorCheckFunc<VerifyPlayerEmailApiResult>());
  }

  public void setPlayerEmailVerificationForm(PlayerEmailVerificationForm playerEmailVerificationForm) {
    this.playerEmailVerificationForm = playerEmailVerificationForm;
  }
}
