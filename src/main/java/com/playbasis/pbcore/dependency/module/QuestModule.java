package com.playbasis.pbcore.dependency.module;

import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.interactor.quest.CancelQuestInteractor;
import com.playbasis.pbcore.domain.interactor.quest.GetMissionInfoInteractor;
import com.playbasis.pbcore.domain.interactor.quest.GetQuestInfoInteractor;
import com.playbasis.pbcore.domain.interactor.quest.GetQuestLeaderboardInteractor;
import com.playbasis.pbcore.domain.interactor.quest.GetQuestListInteractor;
import com.playbasis.pbcore.domain.interactor.quest.JoinQuestInteractor;
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
public class QuestModule {

  @Provides
  @PerActivity
  GetQuestListInteractor provideGetQuestListInteractor(ThreadExecutor threadExecutor,
                                                       PostExecutionThread postExecutionThread,
                                                       RestClient restClient,
                                                       RequestTokenInteractor requestTokenInteractor) {
    return new GetQuestListInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  GetQuestInfoInteractor provideGetQuestInfoInteractor(ThreadExecutor threadExecutor,
                                                       PostExecutionThread postExecutionThread,
                                                       RestClient restClient,
                                                       RequestTokenInteractor requestTokenInteractor) {
    return new GetQuestInfoInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  GetMissionInfoInteractor provideGetMissionInfoInteractor(ThreadExecutor threadExecutor,
                                                           PostExecutionThread postExecutionThread,
                                                           RestClient restClient,
                                                           RequestTokenInteractor requestTokenInteractor) {
    return new GetMissionInfoInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  JoinQuestInteractor provideJoinQuestInteractor(ThreadExecutor threadExecutor,
                                                 PostExecutionThread postExecutionThread,
                                                 RestClient restClient,
                                                 RequestTokenInteractor requestTokenInteractor) {
    return new JoinQuestInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  CancelQuestInteractor provideCancelQuestInteractor(ThreadExecutor threadExecutor,
                                                     PostExecutionThread postExecutionThread,
                                                     RestClient restClient,
                                                     RequestTokenInteractor requestTokenInteractor) {
    return new CancelQuestInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  GetQuestLeaderboardInteractor provideGetQuestLeaderboardInteractor(ThreadExecutor threadExecutor,
                                                                     PostExecutionThread postExecutionThread,
                                                                     RestClient restClient,
                                                                     RequestTokenInteractor requestTokenInteractor) {
    return new GetQuestLeaderboardInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

}
