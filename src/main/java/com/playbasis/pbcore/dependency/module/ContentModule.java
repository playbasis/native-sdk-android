package com.playbasis.pbcore.dependency.module;

import com.playbasis.pbcore.domain.interactor.ContentFeedbackInteractor;
import com.playbasis.pbcore.domain.interactor.CountContentInteractor;
import com.playbasis.pbcore.domain.interactor.DislikeContentInteractor;
import com.playbasis.pbcore.domain.interactor.GetContentsInteractor;
import com.playbasis.pbcore.domain.interactor.LikeContentInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
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
public class ContentModule {

  @Provides
  @PerActivity
  GetContentsInteractor provideGetContentsInteractor(ThreadExecutor threadExecutor,
                                                      PostExecutionThread postExecutionThread,
                                                      RestClient restClient,
                                                      RequestTokenInteractor requestTokenInteractor) {
    return new GetContentsInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  CountContentInteractor provideCountContentInteractor(ThreadExecutor threadExecutor,
                                                       PostExecutionThread postExecutionThread,
                                                       RestClient restClient,
                                                       RequestTokenInteractor requestTokenInteractor) {
    return new CountContentInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  LikeContentInteractor provideLikeContentInteractor(ThreadExecutor threadExecutor,
                                                     PostExecutionThread postExecutionThread,
                                                     RestClient restClient,
                                                     RequestTokenInteractor requestTokenInteractor) {
    return new LikeContentInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  DislikeContentInteractor provideDislikeContentInteractor(ThreadExecutor threadExecutor,
                                                           PostExecutionThread postExecutionThread,
                                                           RestClient restClient,
                                                           RequestTokenInteractor requestTokenInteractor) {
    return new DislikeContentInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  ContentFeedbackInteractor provideContentFeedbackInteractor(ThreadExecutor threadExecutor,
                                                             PostExecutionThread postExecutionThread,
                                                             RestClient restClient,
                                                             RequestTokenInteractor requestTokenInteractor) {
    return new ContentFeedbackInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }
}
