package com.playbasis.pbcore.dependency.module;

import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.goods.GetGoodsInfoInteractor;
import com.playbasis.pbcore.domain.interactor.goods.GetGoodsListInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.interactor.goods.VerifyGoodsCouponInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.dependency.component.PerActivity;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tar on 6/21/16 AD.
 */
@Module
public class GoodsModule {

  @Provides
  @PerActivity
  GetGoodsListInteractor provideGetGoodsListInteractor(PBThreadExecutor threadExecutor,
                                                       PBPostExecutionThread postExecutionThread,
                                                       RestClient restClient,
                                                       RequestTokenInteractor requestTokenInteractor) {
    return new GetGoodsListInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  GetGoodsInfoInteractor provideGetGoodsInfoInteractor(PBThreadExecutor threadExecutor,
                                                       PBPostExecutionThread postExecutionThread,
                                                       RestClient restClient,
                                                       RequestTokenInteractor requestTokenInteractor) {
    return new GetGoodsInfoInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  VerifyGoodsCouponInteractor provideVerifyGoodsCouponInteractor(PBThreadExecutor threadExecutor,
                                                                 PBPostExecutionThread postExecutionThread,
                                                                 RestClient restClient,
                                                                 RequestTokenInteractor requestTokenInteractor) {
    return new VerifyGoodsCouponInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

}
