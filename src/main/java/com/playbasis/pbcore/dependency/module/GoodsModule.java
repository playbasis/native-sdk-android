package com.playbasis.pbcore.dependency.module;

import com.playbasis.pbcore.domain.interactor.GetGoodsInfoInteractor;
import com.playbasis.pbcore.domain.interactor.GetGoodsListInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.interactor.VerifyGoodsCouponInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.smartsoftasia.ssalibrary.dependency.component.PerActivity;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tar on 6/21/16 AD.
 */
@Module
public class GoodsModule {

  @Provides
  @PerActivity
  GetGoodsListInteractor provideGetGoodsListInteractor(ThreadExecutor threadExecutor,
                                                       PostExecutionThread postExecutionThread,
                                                       RestClient restClient,
                                                       RequestTokenInteractor requestTokenInteractor) {
    return new GetGoodsListInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  GetGoodsInfoInteractor provideGetGoodsInfoInteractor(ThreadExecutor threadExecutor,
                                                       PostExecutionThread postExecutionThread,
                                                       RestClient restClient,
                                                       RequestTokenInteractor requestTokenInteractor) {
    return new GetGoodsInfoInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  VerifyGoodsCouponInteractor provideVerifyGoodsCouponInteractor(ThreadExecutor threadExecutor,
                                                                 PostExecutionThread postExecutionThread,
                                                                 RestClient restClient,
                                                                 RequestTokenInteractor requestTokenInteractor) {
    return new VerifyGoodsCouponInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

}
