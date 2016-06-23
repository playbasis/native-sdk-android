package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.PlayerEmailVerificationForm;
import com.playbasis.pbcore.rest.result.VerifyPlayerEmailApiResult;
import com.playbasis.pbcore.rest.result.function.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class VerifyPlayerEmailInteractor extends PlayBasisApiInteractor {

  public PlayerEmailVerificationForm playerEmailVerificationForm;

  @Inject
  public VerifyPlayerEmailInteractor(ThreadExecutor threadExecutor,
                                     PostExecutionThread postExecutionThread,
                                     RestClient restClient,
                                     RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .sendPlayerVerifyEmail(playerEmailVerificationForm.getPlayerId(), getApiToken())
        .map(new PBApiErrorCheckFunc<VerifyPlayerEmailApiResult>());
  }

  public void setPlayerEmailVerificationForm(PlayerEmailVerificationForm playerEmailVerificationForm) {
    this.playerEmailVerificationForm = playerEmailVerificationForm;
  }
}
