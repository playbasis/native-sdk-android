package com.playbasis.pbcore.domain.interactor.communication;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.communication.SendEmailForm;
import com.playbasis.pbcore.rest.result.communication.SendEmailApiResult;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class SendEmailInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "RuleInteractor";

  protected SendEmailForm sendEmailForm;

  @Inject
  public SendEmailInteractor(PBThreadExecutor threadExecutor,
                             PBPostExecutionThread postExecutionThread,
                             RestClient restClient,
                             RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getCommunicationService()
        .sendEmail(
            getApiToken(),
            sendEmailForm.getPlayerId(),
            sendEmailForm.getSubject(),
            sendEmailForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<SendEmailApiResult>());
  }

  public void setSendEmailForm(SendEmailForm sendEmailForm) {
    this.sendEmailForm = sendEmailForm;
  }
}
