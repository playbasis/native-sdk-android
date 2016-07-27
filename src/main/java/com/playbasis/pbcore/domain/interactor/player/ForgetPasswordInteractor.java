package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.ForgetPlayerPasswordForm;
import com.playbasis.pbcore.rest.result.player.ForgetPasswordApiResult;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class ForgetPasswordInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "ForgetPasswordInteractor";

  protected ForgetPlayerPasswordForm forgetPlayerPasswordForm;

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
            getApiToken(),
            forgetPlayerPasswordForm.getEmail()
        ).map(new PBApiErrorCheckFunc<ForgetPasswordApiResult>());
  }

  public void setForgetPlayerPasswordForm(ForgetPlayerPasswordForm forgetPlayerPasswordForm) {
    this.forgetPlayerPasswordForm = forgetPlayerPasswordForm;
  }
}
