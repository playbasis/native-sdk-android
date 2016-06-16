package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.PlayerEmailVerificationForm;
import com.playbasis.pbcore.rest.form.PlayerRegistrationForm;
import com.playbasis.pbcore.rest.result.RegisterPlayerApiResult;
import com.playbasis.pbcore.rest.result.VerifyPlayerEmailApiResult;
import com.playbasis.pbcore.rest.result.function.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class RegisterPlayerInteractor extends PlayBasisApiInteractor {

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
    return restClient.getPlayerService()
        .registerPlayer(
            playerRegistrationForm.getPlayerId(),
            token.token,
            playerRegistrationForm.getUserName(),
            playerRegistrationForm.getEmail(),
            playerRegistrationForm.getImageUrl(),
            playerRegistrationForm.getPassword(),
            playerRegistrationForm.getStatus())
        .map(new PBApiErrorCheckFunc<RegisterPlayerApiResult>())
        .flatMap(new Func1<RegisterPlayerApiResult, Observable<VerifyPlayerEmailApiResult>>() {
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

  public void setPlayerRegistrationForm(PlayerRegistrationForm playerRegistrationForm) {
    this.playerRegistrationForm = playerRegistrationForm;
    this.verifyPlayerEmailInteractor.setPlayerEmailVerificationForm(new PlayerEmailVerificationForm(playerRegistrationForm.getPlayerId()));
  }
}
