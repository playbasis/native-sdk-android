package com.playbasis.pbcore.dependency.module;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.interactor.quest.CancelQuestInteractor;
import com.playbasis.pbcore.domain.interactor.quest.GetMissionInfoInteractor;
import com.playbasis.pbcore.domain.interactor.quest.GetQuestInfoInteractor;
import com.playbasis.pbcore.domain.interactor.quest.GetQuestLeaderboardInteractor;
import com.playbasis.pbcore.domain.interactor.quest.GetQuestListInteractor;
import com.playbasis.pbcore.domain.interactor.quest.JoinQuestInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.dependency.component.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tar on 4/21/16 AD.
 */
@Module
public class QuestModule {

  @Provides
  @PerActivity
  GetQuestListInteractor provideGetQuestListInteractor(PBThreadExecutor threadExecutor,
                                                       PBPostExecutionThread postExecutionThread,
                                                       RestClient restClient,
                                                       RequestTokenInteractor requestTokenInteractor) {
    return new GetQuestListInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  GetQuestInfoInteractor provideGetQuestInfoInteractor(PBThreadExecutor threadExecutor,
                                                       PBPostExecutionThread postExecutionThread,
                                                       RestClient restClient,
                                                       RequestTokenInteractor requestTokenInteractor) {
    return new GetQuestInfoInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  GetMissionInfoInteractor provideGetMissionInfoInteractor(PBThreadExecutor threadExecutor,
                                                           PBPostExecutionThread postExecutionThread,
                                                           RestClient restClient,
                                                           RequestTokenInteractor requestTokenInteractor) {
    return new GetMissionInfoInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  JoinQuestInteractor provideJoinQuestInteractor(PBThreadExecutor threadExecutor,
                                                 PBPostExecutionThread postExecutionThread,
                                                 RestClient restClient,
                                                 RequestTokenInteractor requestTokenInteractor) {
    return new JoinQuestInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  CancelQuestInteractor provideCancelQuestInteractor(PBThreadExecutor threadExecutor,
                                                     PBPostExecutionThread postExecutionThread,
                                                     RestClient restClient,
                                                     RequestTokenInteractor requestTokenInteractor) {
    return new CancelQuestInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  GetQuestLeaderboardInteractor provideGetQuestLeaderboardInteractor(PBThreadExecutor threadExecutor,
                                                                     PBPostExecutionThread postExecutionThread,
                                                                     RestClient restClient,
                                                                     RequestTokenInteractor requestTokenInteractor) {
    return new GetQuestLeaderboardInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

}
