package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.VerifyOTPCodeForm;
import com.playbasis.pbcore.rest.result.player.VerifyOTPCodeApiResult;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class VerifyOTPCodeInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "RequestOTPCodeInteractor";

  protected VerifyOTPCodeForm verifyOTPCodeForm;

  @Inject
  public VerifyOTPCodeInteractor(PBThreadExecutor threadExecutor,
                                 PBPostExecutionThread postExecutionThread,
                                 RestClient restClient,
                                 RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .verifyOTPCode(
            verifyOTPCodeForm.getPlayerId(),
            getApiToken(),
            verifyOTPCodeForm.getCode(),
            verifyOTPCodeForm.getFields()
        ).map(new PBApiErrorCheckFunc<VerifyOTPCodeApiResult>());
  }

  public void setVerifyOTPCodeForm(VerifyOTPCodeForm verifyOTPCodeForm) {
    this.verifyOTPCodeForm = verifyOTPCodeForm;
  }
}
