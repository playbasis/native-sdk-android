package com.playbasis.pbcore.domain.interactor.goods;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.goods.VerifyGoodsCouponForm;
import com.playbasis.pbcore.rest.result.goods.VerifyGoodsCouponApiResult;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class VerifyGoodsCouponInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "VerifyGoodsCouponInteractor";

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
            getApiKey(),
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
