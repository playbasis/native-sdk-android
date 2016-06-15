package com.playbasis.pbcore.dependency.module;

import com.playbasis.pbcore.domain.controller.PBSharedPreference;
import com.playbasis.pbcore.domain.interactor.GetOrganizationInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.smartsoftasia.ssalibrary.dependency.component.PerActivity;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tar on 4/21/16 AD.
 */
@Module
public class OrganizationModule {

  @Provides
  @PerActivity
  GetOrganizationInteractor provideGetOrganizationInteractor(ThreadExecutor threadExecutor,
                                                             PostExecutionThread postExecutionThread,
                                                             RestClient restClient,
                                                             PBSharedPreference sharedPreference) {
    return new GetOrganizationInteractor(threadExecutor, postExecutionThread, restClient, sharedPreference);
  }

}
