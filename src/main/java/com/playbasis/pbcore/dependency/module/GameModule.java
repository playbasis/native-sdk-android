package com.playbasis.pbcore.dependency.module;

import com.playbasis.pbcore.dependency.component.PerActivity;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.interactor.game.GetGameSettingInteractor;
import com.playbasis.pbcore.rest.RestClient;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tar on 4/21/16 AD.
 * GameModule
 */
@Module
public class GameModule {

  @Provides
  @PerActivity
  GetGameSettingInteractor provideGetGameSettingInteractor(PBThreadExecutor threadExecutor,
                                                           PBPostExecutionThread postExecutionThread,
                                                           RestClient restClient,
                                                           RequestTokenInteractor requestTokenInteractor) {
    return new GetGameSettingInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }
}
