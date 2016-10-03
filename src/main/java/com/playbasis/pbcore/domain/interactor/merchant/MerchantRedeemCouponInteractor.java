package com.playbasis.pbcore.domain.interactor.merchant;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.merchant.RedeemCouponForm;
import com.playbasis.pbcore.rest.result.merchant.RedeemCouponApiResult;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class MerchantRedeemCouponInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "RedeemGoodsCouponInteractor";

  protected RedeemCouponForm redeemCouponForm;

  @Inject
  public MerchantRedeemCouponInteractor(PBThreadExecutor threadExecutor,
                                        PBPostExecutionThread postExecutionThread,
                                        RestClient restClient,
                                        RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getMerchantService()
        .redeemCoupon(
            getApiToken(),
            redeemCouponForm.getGoodsGroup(),
            redeemCouponForm.getCouponCode(),
            redeemCouponForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<RedeemCouponApiResult>());
  }

  public void setRedeemCouponForm(RedeemCouponForm redeemCouponForm) {
    this.redeemCouponForm = redeemCouponForm;
  }
}
