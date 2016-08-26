package com.playbasis.pbcore.domain.interactor.communication;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.communication.SendEmailCouponForm;
import com.playbasis.pbcore.rest.result.communication.SendEmailCouponApiResult;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class SendEmailCouponInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "RuleInteractor";

  protected SendEmailCouponForm sendEmailCouponForm;

  @Inject
  public SendEmailCouponInteractor(PBThreadExecutor threadExecutor,
                                   PBPostExecutionThread postExecutionThread,
                                   RestClient restClient,
                                   RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getCommunicationService()
        .sendEmailCoupon(
            getApiToken(),
            sendEmailCouponForm.getPlayerId(),
            sendEmailCouponForm.getSubject(),
            sendEmailCouponForm.getRefId(),
            sendEmailCouponForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<SendEmailCouponApiResult>());
  }

  public void setSendEmailCouponForm(SendEmailCouponForm sendEmailCouponForm) {
    this.sendEmailCouponForm = sendEmailCouponForm;
  }
}
