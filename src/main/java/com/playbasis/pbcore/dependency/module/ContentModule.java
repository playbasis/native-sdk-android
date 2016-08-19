package com.playbasis.pbcore.dependency.module;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.content.ContentFeedbackInteractor;
import com.playbasis.pbcore.domain.interactor.content.CountContentInteractor;
import com.playbasis.pbcore.domain.interactor.content.DislikeContentInteractor;
import com.playbasis.pbcore.domain.interactor.content.GetContentsInteractor;
import com.playbasis.pbcore.domain.interactor.content.LikeContentInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.dependency.component.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tar on 4/21/16 AD.
 */
@Module
public class ContentModule {

  @Provides
  @PerActivity
  GetContentsInteractor provideGetContentsInteractor(PBThreadExecutor threadExecutor,
                                                      PBPostExecutionThread postExecutionThread,
                                                      RestClient restClient,
                                                      RequestTokenInteractor requestTokenInteractor) {
    return new GetContentsInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  CountContentInteractor provideCountContentInteractor(PBThreadExecutor threadExecutor,
                                                       PBPostExecutionThread postExecutionThread,
                                                       RestClient restClient,
                                                       RequestTokenInteractor requestTokenInteractor) {
    return new CountContentInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  LikeContentInteractor provideLikeContentInteractor(PBThreadExecutor threadExecutor,
                                                     PBPostExecutionThread postExecutionThread,
                                                     RestClient restClient,
                                                     RequestTokenInteractor requestTokenInteractor) {
    return new LikeContentInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  DislikeContentInteractor provideDislikeContentInteractor(PBThreadExecutor threadExecutor,
                                                           PBPostExecutionThread postExecutionThread,
                                                           RestClient restClient,
                                                           RequestTokenInteractor requestTokenInteractor) {
    return new DislikeContentInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  ContentFeedbackInteractor provideContentFeedbackInteractor(PBThreadExecutor threadExecutor,
                                                             PBPostExecutionThread postExecutionThread,
                                                             RestClient restClient,
                                                             RequestTokenInteractor requestTokenInteractor) {
    return new ContentFeedbackInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }
}
