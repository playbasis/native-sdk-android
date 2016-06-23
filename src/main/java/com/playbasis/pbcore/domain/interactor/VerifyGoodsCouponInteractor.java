package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.VerifyGoodsCouponForm;
import com.playbasis.pbcore.rest.result.VerifyGoodsCouponApiResult;
import com.playbasis.pbcore.rest.result.function.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class VerifyGoodsCouponInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetIdeasInteractor";

  private VerifyGoodsCouponForm verifyGoodsCouponForm;

  @Inject
  public VerifyGoodsCouponInteractor(ThreadExecutor threadExecutor,
                                     PostExecutionThread postExecutionThread,
                                     RestClient restClient,
                                     RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getGoodsService()
        .verifyGoodsCoupon(
            restClient.getApiKey(),
            verifyGoodsCouponForm.getGoodsId(),
            verifyGoodsCouponForm.getCode(),
            verifyGoodsCouponForm.getPlayerId()
        )
        .map(new PBApiErrorCheckFunc<VerifyGoodsCouponApiResult>());
  }

  public void setVerifyGoodsCouponForm(VerifyGoodsCouponForm verifyGoodsCouponForm) {
    this.verifyGoodsCouponForm = verifyGoodsCouponForm;
  }
}
