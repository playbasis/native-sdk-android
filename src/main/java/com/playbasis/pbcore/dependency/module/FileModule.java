package com.playbasis.pbcore.dependency.module;

import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.interactor.file.UploadImageInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.dependency.component.PerActivity;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tar on 4/21/16 AD.
 */
@Module
public class FileModule {

  @Provides
  @PerActivity
  UploadImageInteractor provideUploadImageInteractor(PBThreadExecutor threadExecutor,
                                                     PBPostExecutionThread postExecutionThread,
                                                     RestClient restClient,
                                                     RequestTokenInteractor requestTokenInteractor) {
    return new UploadImageInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

}
