package com.playbasis.pbcore.dependency.module;

import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.interactor.redeem.RedeemGoodsGroupInteractor;
import com.playbasis.pbcore.domain.interactor.redeem.RedeemGoodsInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.smartsoftasia.ssalibrary.dependency.component.PerActivity;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tar on 8/17/16 AD.
 */
@Module
public class RedeemModule {

  @Provides
  @PerActivity
  RedeemGoodsInteractor provideRedeemGoodsInteractor(ThreadExecutor threadExecutor,
                                                     PostExecutionThread postExecutionThread,
                                                     RestClient restClient,
                                                     RequestTokenInteractor requestTokenInteractor) {
    return new RedeemGoodsInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  RedeemGoodsGroupInteractor provideRedeemGoodsGroupInteractor(ThreadExecutor threadExecutor,
                                                               PostExecutionThread postExecutionThread,
                                                               RestClient restClient,
                                                               RequestTokenInteractor requestTokenInteractor) {
    return new RedeemGoodsGroupInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }
}
