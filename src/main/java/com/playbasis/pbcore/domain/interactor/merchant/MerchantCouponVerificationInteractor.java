package com.playbasis.pbcore.domain.interactor.merchant;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.merchant.CouponVerificationForm;
import com.playbasis.pbcore.rest.result.merchant.CouponVerificationApiResult;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class MerchantCouponVerificationInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "RedeemGoodsCouponInteractor";

  protected CouponVerificationForm couponVerificationForm;

  @Inject
  public MerchantCouponVerificationInteractor(PBThreadExecutor threadExecutor,
                                              PBPostExecutionThread postExecutionThread,
                                              RestClient restClient,
                                              RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getMerchantService()
        .verifyCoupon(
            getApiKey(),
            couponVerificationForm.getGoodsGroup(),
            couponVerificationForm.getCouponCode(),
            couponVerificationForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<CouponVerificationApiResult>());
  }

  public void setCouponVerificationForm(CouponVerificationForm couponVerificationForm) {
    this.couponVerificationForm = couponVerificationForm;
  }
}
