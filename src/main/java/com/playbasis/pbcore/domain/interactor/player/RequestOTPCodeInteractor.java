package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.RequestOTPCodeForm;
import com.playbasis.pbcore.rest.result.player.RequestOTPCodeApiResult;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class RequestOTPCodeInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "RequestOTPCodeInteractor";

  protected RequestOTPCodeForm requestOTPCodeForm;

  @Inject
  public RequestOTPCodeInteractor(PBThreadExecutor threadExecutor,
                                  PBPostExecutionThread postExecutionThread,
                                  RestClient restClient,
                                  RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .requestOTPCode(
            requestOTPCodeForm.getPlayerId(),
            getApiToken(),
            requestOTPCodeForm.getFields()
        ).map(new PBApiErrorCheckFunc<RequestOTPCodeApiResult>());
  }

  public void setRequestOTPCodeForm(RequestOTPCodeForm requestOTPCodeForm) {
    this.requestOTPCodeForm = requestOTPCodeForm;
  }
}
