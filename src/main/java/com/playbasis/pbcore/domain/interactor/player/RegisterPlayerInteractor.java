package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.PlayerEmailVerificationForm;
import com.playbasis.pbcore.rest.form.player.PlayerRegistrationForm;
import com.playbasis.pbcore.rest.result.player.RegisterPlayerApiResult;
import com.playbasis.pbcore.rest.result.player.VerifyPlayerEmailApiResult;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class RegisterPlayerInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "RegisterPlayerInteractor";

  public PlayerRegistrationForm playerRegistrationForm;
  private VerifyPlayerEmailInteractor verifyPlayerEmailInteractor;
  private RegisterPlayerApiResult registerPlayerApiResult;

  @Inject
  public RegisterPlayerInteractor(ThreadExecutor threadExecutor,
                                  PostExecutionThread postExecutionThread,
                                  RestClient restClient,
                                  RequestTokenInteractor requestTokenInteractor,
                                  VerifyPlayerEmailInteractor verifyPlayerEmailInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
    this.verifyPlayerEmailInteractor = verifyPlayerEmailInteractor;
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    Observable observable = restClient.getPlayerService()
        .registerPlayer(
            playerRegistrationForm.getPlayerId(),
            getApiToken(),
            playerRegistrationForm.getUserName(),
            playerRegistrationForm.getEmail(),
            playerRegistrationForm.getImageUrl(),
            playerRegistrationForm.getPassword(),
            playerRegistrationForm.getStatus())
        .map(new PBApiErrorCheckFunc<RegisterPlayerApiResult>());


    if (playerRegistrationForm.isSendVerificationEmail()) {
      observable = observable.flatMap(new Func1<RegisterPlayerApiResult, Observable<VerifyPlayerEmailApiResult>>() {
        @Override
        public Observable<VerifyPlayerEmailApiResult> call(RegisterPlayerApiResult result) {
          registerPlayerApiResult = result;
          return verifyPlayerEmailInteractor.buildUseCaseObservable();
        }
      }).map(new Func1<VerifyPlayerEmailApiResult, RegisterPlayerApiResult>() {
        @Override
        public RegisterPlayerApiResult call(VerifyPlayerEmailApiResult verifyPlayerEmailApiResult) {
          registerPlayerApiResult.success = registerPlayerApiResult.success && verifyPlayerEmailApiResult.success;
          return registerPlayerApiResult;
        }
      });
    }

    return observable;
  }

  public void setPlayerRegistrationForm(PlayerRegistrationForm playerRegistrationForm) {
    this.playerRegistrationForm = playerRegistrationForm;
    this.verifyPlayerEmailInteractor.setPlayerEmailVerificationForm(new PlayerEmailVerificationForm(playerRegistrationForm.getPlayerId()));
  }
}