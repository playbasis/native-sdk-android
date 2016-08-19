package com.playbasis.pbcore.dependency.module;

import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.interactor.redeem.RedeemGoodsGroupInteractor;
import com.playbasis.pbcore.domain.interactor.redeem.RedeemGoodsInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.dependency.component.PerActivity;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tar on 8/17/16 AD.
 */
@Module
public class RedeemModule {

  @Provides
  @PerActivity
  RedeemGoodsInteractor provideRedeemGoodsInteractor(PBThreadExecutor threadExecutor,
                                                     PBPostExecutionThread postExecutionThread,
                                                     RestClient restClient,
                                                     RequestTokenInteractor requestTokenInteractor) {
    return new RedeemGoodsInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  RedeemGoodsGroupInteractor provideRedeemGoodsGroupInteractor(PBThreadExecutor threadExecutor,
                                                               PBPostExecutionThread postExecutionThread,
                                                               RestClient restClient,
                                                               RequestTokenInteractor requestTokenInteractor) {
    return new RedeemGoodsGroupInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }
}
