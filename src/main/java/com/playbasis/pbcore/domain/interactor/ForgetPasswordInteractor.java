package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.ForgetPlayerPasswordForm;
import com.playbasis.pbcore.rest.result.ForgetPasswordApiResult;
import com.playbasis.pbcore.rest.result.function.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class ForgetPasswordInteractor extends PlayBasisApiInteractor {

  public ForgetPlayerPasswordForm forgetPlayerPasswordForm;

  @Inject
  public ForgetPasswordInteractor(ThreadExecutor threadExecutor,
                                  PostExecutionThread postExecutionThread,
                                  RestClient restClient,
                                  RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .forgetPlayerPassword(
            token.token,
            forgetPlayerPasswordForm.getEmail()
        ).map(new PBApiErrorCheckFunc<ForgetPasswordApiResult>());
  }

  public void setForgetPlayerPasswordForm(ForgetPlayerPasswordForm forgetPlayerPasswordForm) {
    this.forgetPlayerPasswordForm = forgetPlayerPasswordForm;
  }
}
