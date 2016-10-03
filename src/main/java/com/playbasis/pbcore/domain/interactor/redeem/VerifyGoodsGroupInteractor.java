package com.playbasis.pbcore.domain.interactor.redeem;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.redeem.VerifyGoodsGroupForm;
import com.playbasis.pbcore.rest.result.redeem.VerifyGoodsGroupApiResult;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class VerifyGoodsGroupInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "RedeemGoodsCouponInteractor";

  protected VerifyGoodsGroupForm verifyGoodsGroupForm;

  @Inject
  public VerifyGoodsGroupInteractor(PBThreadExecutor threadExecutor,
                                    PBPostExecutionThread postExecutionThread,
                                    RestClient restClient,
                                    RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getRedeemService()
        .verifyGoodsGroup(
            getApiToken(),
            verifyGoodsGroupForm.getGoodsGroup(),
            verifyGoodsGroupForm.getCouponCode(),
            verifyGoodsGroupForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<VerifyGoodsGroupApiResult>());
  }

  public void setVerifyGoodsGroupForm(VerifyGoodsGroupForm verifyGoodsGroupForm) {
    this.verifyGoodsGroupForm = verifyGoodsGroupForm;
  }
}
