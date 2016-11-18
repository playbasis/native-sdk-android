package com.playbasis.pbcore.dependency.module;

import com.playbasis.pbcore.dependency.component.PerActivity;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.Link.GenerateLinkInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.interactor.point.ApproveTransactionInteractor;
import com.playbasis.pbcore.domain.interactor.point.GetRemainingPointsInteractor;
import com.playbasis.pbcore.rest.RestClient;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tar on 4/21/16 AD.
 */
@Module
public class PointModule {

  @Provides
  @PerActivity
  GetRemainingPointsInteractor provideGetRemainingPointsInteractor(PBThreadExecutor threadExecutor,
                                                                   PBPostExecutionThread postExecutionThread,
                                                                   RestClient restClient,
                                                                   RequestTokenInteractor requestTokenInteractor) {
    return new GetRemainingPointsInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  ApproveTransactionInteractor provideApproveTransactionInteractor(PBThreadExecutor threadExecutor,
                                                                   PBPostExecutionThread postExecutionThread,
                                                                   RestClient restClient,
                                                                   RequestTokenInteractor requestTokenInteractor) {
    return new ApproveTransactionInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }
}
