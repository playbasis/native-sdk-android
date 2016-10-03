package com.playbasis.pbcore.dependency.module;

import com.playbasis.pbcore.dependency.component.PerActivity;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.interactor.merchant.AvailableBranchForGoodsGroupInteractor;
import com.playbasis.pbcore.domain.interactor.merchant.MerchantCouponVerificationInteractor;
import com.playbasis.pbcore.domain.interactor.merchant.MerchantRedeemCouponInteractor;
import com.playbasis.pbcore.rest.RestClient;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tar on 4/21/16 AD.
 */
@Module
public class MerchantModule {

  @Provides
  @PerActivity
  AvailableBranchForGoodsGroupInteractor provideAvailableBranchForGoodsGroupInteractor(PBThreadExecutor threadExecutor,
                                                                                       PBPostExecutionThread postExecutionThread,
                                                                                       RestClient restClient,
                                                                                       RequestTokenInteractor requestTokenInteractor) {
    return new AvailableBranchForGoodsGroupInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  MerchantCouponVerificationInteractor provideVerifyGoodsGroupInteractor(PBThreadExecutor threadExecutor,
                                                                         PBPostExecutionThread postExecutionThread,
                                                                         RestClient restClient,
                                                                         RequestTokenInteractor requestTokenInteractor) {
    return new MerchantCouponVerificationInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  MerchantRedeemCouponInteractor provideRedeemGoodsGroupInteractor(PBThreadExecutor threadExecutor,
                                                                   PBPostExecutionThread postExecutionThread,
                                                                   RestClient restClient,
                                                                   RequestTokenInteractor requestTokenInteractor) {
    return new MerchantRedeemCouponInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }
}
