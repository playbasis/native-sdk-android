package com.playbasis.pbcore.dependency.module;

import com.playbasis.pbcore.dependency.component.PerActivity;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.interactor.generic.GenericGetInteractor;
import com.playbasis.pbcore.domain.interactor.generic.GenericPostInteractor;
import com.playbasis.pbcore.rest.RestClient;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tar on 4/21/16 AD.
 */
@Module
public class GenericModule {

  @Provides
  @PerActivity
  GenericGetInteractor provideGenericGetInteractor(PBThreadExecutor threadExecutor,
                                                   PBPostExecutionThread postExecutionThread,
                                                   RestClient restClient,
                                                   RequestTokenInteractor requestTokenInteractor) {
    return new GenericGetInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  GenericPostInteractor provideGenericPostInteractor(PBThreadExecutor threadExecutor,
                                                     PBPostExecutionThread postExecutionThread,
                                                     RestClient restClient,
                                                     RequestTokenInteractor requestTokenInteractor) {
    return new GenericPostInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

}
