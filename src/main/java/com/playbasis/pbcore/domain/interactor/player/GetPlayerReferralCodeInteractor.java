package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.ReferralCodeForm;
import com.playbasis.pbcore.rest.result.player.ReferralCodeApiResult;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetPlayerReferralCodeInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "RequestOTPCodeInteractor";

  protected ReferralCodeForm referralCodeForm;

  @Inject
  public GetPlayerReferralCodeInteractor(PBThreadExecutor threadExecutor,
                                         PBPostExecutionThread postExecutionThread,
                                         RestClient restClient,
                                         RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .referralCode(
            referralCodeForm.getPlayerId(),
            getApiKey(),
            referralCodeForm.getFields())
        .map(new PBApiErrorCheckFunc<ReferralCodeApiResult>());
  }

  public void setReferralCodeForm(ReferralCodeForm referralCodeForm) {
    this.referralCodeForm = referralCodeForm;
  }
}
