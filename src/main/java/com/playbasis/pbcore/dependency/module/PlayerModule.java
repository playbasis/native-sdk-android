package com.playbasis.pbcore.dependency.module;

import com.playbasis.pbcore.domain.interactor.ForgetPasswordInteractor;
import com.playbasis.pbcore.domain.interactor.GetPlayerAllBadgesInteractor;
import com.playbasis.pbcore.domain.interactor.GetPlayerCustomFieldsInteractor;
import com.playbasis.pbcore.domain.interactor.GetPlayerEarnedBadgesInteractor;
import com.playbasis.pbcore.domain.interactor.GetPlayerInteractor;
import com.playbasis.pbcore.domain.interactor.PlayerAuthenticationInteractor;
import com.playbasis.pbcore.domain.interactor.RegisterPlayerInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.interactor.SetPlayerCustomFieldsInteractor;
import com.playbasis.pbcore.domain.interactor.UpdatePlayerInteractor;
import com.playbasis.pbcore.domain.interactor.UpdatePlayerOrganizableModelInteractor;
import com.playbasis.pbcore.domain.interactor.UploadImageInteractor;
import com.playbasis.pbcore.domain.interactor.VerifyPlayerEmailInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.smartsoftasia.ssalibrary.dependency.component.PerActivity;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tar on 5/5/16 AD.
 */
@Module
public class PlayerModule {

  @Provides
  @PerActivity
  RegisterPlayerInteractor provideRegisterUserInteractor(ThreadExecutor threadExecutor,
                                                         PostExecutionThread postExecutionThread,
                                                         RestClient restClient,
                                                         RequestTokenInteractor requestTokenInteractor,
                                                         VerifyPlayerEmailInteractor verifyPlayerEmailInteractor) {
    return new RegisterPlayerInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor, verifyPlayerEmailInteractor);
  }

  @Provides
  @PerActivity
  VerifyPlayerEmailInteractor provideVerifyUserEmailInteractor(ThreadExecutor threadExecutor,
                                                               PostExecutionThread postExecutionThread,
                                                               RestClient restClient,
                                                               RequestTokenInteractor requestTokenInteractor) {
    return new VerifyPlayerEmailInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  ForgetPasswordInteractor provideForgetPasswordInteractor(ThreadExecutor threadExecutor,
                                                           PostExecutionThread postExecutionThread,
                                                           RestClient restClient,
                                                           RequestTokenInteractor requestTokenInteractor) {
    return new ForgetPasswordInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  PlayerAuthenticationInteractor providePlayerAuthenticationInteractor(ThreadExecutor threadExecutor,
                                                                       PostExecutionThread postExecutionThread,
                                                                       RestClient restClient,
                                                                       RequestTokenInteractor requestTokenInteractor) {
    return new PlayerAuthenticationInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  GetPlayerInteractor provideGetPlayerInteractor(ThreadExecutor threadExecutor,
                                                 PostExecutionThread postExecutionThread,
                                                 RestClient restClient,
                                                 RequestTokenInteractor requestTokenInteractor,
                                                 GetPlayerCustomFieldsInteractor getPlayerCustomFieldsInteractor) {
    return new GetPlayerInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor, getPlayerCustomFieldsInteractor);
  }

  @Provides
  @PerActivity
  GetPlayerCustomFieldsInteractor provideGetUserCustomFieldsInteractor(ThreadExecutor threadExecutor,
                                                                       PostExecutionThread postExecutionThread,
                                                                       RestClient restClient,
                                                                       RequestTokenInteractor requestTokenInteractor) {
    return new GetPlayerCustomFieldsInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  UpdatePlayerInteractor provideUpdateUserInteractor(ThreadExecutor threadExecutor,
                                                     PostExecutionThread postExecutionThread,
                                                     RestClient restClient,
                                                     RequestTokenInteractor requestTokenInteractor,
                                                     UploadImageInteractor uploadImageInteractor) {
    return new UpdatePlayerInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor, uploadImageInteractor);
  }

  @Provides
  @PerActivity
  SetPlayerCustomFieldsInteractor provideSetUserCustomFieldInteractor(ThreadExecutor threadExecutor,
                                                                      PostExecutionThread postExecutionThread,
                                                                      RestClient restClient,
                                                                      RequestTokenInteractor requestTokenInteractor) {
    return new SetPlayerCustomFieldsInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  UpdatePlayerOrganizableModelInteractor provideUpdateUserOrganizableModelInteractor(ThreadExecutor threadExecutor,
                                                                                     PostExecutionThread postExecutionThread,
                                                                                     RestClient restClient,
                                                                                     RequestTokenInteractor requestTokenInteractor) {
    return new UpdatePlayerOrganizableModelInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  GetPlayerEarnedBadgesInteractor provideGetPlayerEarnedBadgesInteractor(ThreadExecutor threadExecutor,
                                                                         PostExecutionThread postExecutionThread,
                                                                         RestClient restClient,
                                                                         RequestTokenInteractor requestTokenInteractor) {
    return new GetPlayerEarnedBadgesInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  GetPlayerAllBadgesInteractor provideGetPlayerAllBadgesInteractor(ThreadExecutor threadExecutor,
                                                                   PostExecutionThread postExecutionThread,
                                                                   RestClient restClient,
                                                                   RequestTokenInteractor requestTokenInteractor) {
    return new GetPlayerAllBadgesInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }
}
