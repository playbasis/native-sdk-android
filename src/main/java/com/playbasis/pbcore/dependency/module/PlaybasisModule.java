package com.playbasis.pbcore.dependency.module;

import android.app.Application;
import android.content.Context;

import com.playbasis.pbcore.domain.controller.PBSharedPreference;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tar on 4/21/16 AD.
 */
@Module
public class PlaybasisModule {

  private Application application;

  public PlaybasisModule(Application application) {
    this.application = application;
  }

  @Provides
  @Singleton
  Application provideApplication() {
    return this.application;
  }

  @Provides
  @Singleton
  Context provideApplicationContext() {
    return this.application;
  }

  @Provides
  @Singleton
  RequestTokenInteractor provideRequestTokenInteractor(PBThreadExecutor threadExecutor,
                                                       PBPostExecutionThread postExecutionThread,
                                                       RestClient restClient,
                                                       PBSharedPreference sharedPreference) {
    return new RequestTokenInteractor(threadExecutor, postExecutionThread, restClient, sharedPreference);
  }

  @Provides
  @Singleton
  RestClient provideRestClient(Context context, PBThreadExecutor threadExecutor) {
    return new RestClient(context, threadExecutor);
  }

}
