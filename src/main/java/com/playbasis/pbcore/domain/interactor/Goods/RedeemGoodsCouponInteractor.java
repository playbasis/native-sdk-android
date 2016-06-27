package com.playbasis.pbcore.domain.interactor.goods;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.goods.RedeemGoodsCouponForm;
import com.playbasis.pbcore.rest.result.goods.RedeemGoodsCouponApiResult;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class RedeemGoodsCouponInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "RedeemGoodsCouponInteractor";

  private RedeemGoodsCouponForm redeemGoodsCouponForm;

  @Inject
  public RedeemGoodsCouponInteractor(ThreadExecutor threadExecutor,
                                     PostExecutionThread postExecutionThread,
                                     RestClient restClient,
                                     RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getGoodsService()
        .redeemGoodsCoupon(
            getApiToken(),
            redeemGoodsCouponForm.getGoodsId(),
            redeemGoodsCouponForm.getCode(),
            redeemGoodsCouponForm.getPlayerId()
        )
        .map(new PBApiErrorCheckFunc<RedeemGoodsCouponApiResult>());
  }

  public void setRedeemGoodsCouponForm(RedeemGoodsCouponForm redeemGoodsCouponForm) {
    this.redeemGoodsCouponForm = redeemGoodsCouponForm;
  }
}
