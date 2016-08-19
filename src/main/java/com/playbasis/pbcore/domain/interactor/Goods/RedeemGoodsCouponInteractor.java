package com.playbasis.pbcore.domain.interactor.goods;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.goods.RedeemGoodsCouponForm;
import com.playbasis.pbcore.rest.result.goods.RedeemGoodsCouponApiResult;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class RedeemGoodsCouponInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "RedeemGoodsCouponInteractor";

  protected RedeemGoodsCouponForm redeemGoodsCouponForm;

  @Inject
  public RedeemGoodsCouponInteractor(PBThreadExecutor threadExecutor,
                                     PBPostExecutionThread postExecutionThread,
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
            redeemGoodsCouponForm.getPlayerId(),
            redeemGoodsCouponForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<RedeemGoodsCouponApiResult>());
  }

  public void setRedeemGoodsCouponForm(RedeemGoodsCouponForm redeemGoodsCouponForm) {
    this.redeemGoodsCouponForm = redeemGoodsCouponForm;
  }
}
