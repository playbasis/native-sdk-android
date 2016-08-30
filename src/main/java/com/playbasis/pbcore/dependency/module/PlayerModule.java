package com.playbasis.pbcore.dependency.module;

import com.playbasis.pbcore.dependency.component.PerActivity;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.interactor.player.ForgetPasswordInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerAllBadgesInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerAllGoodsInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerAllPointsInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerAllQuestInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerCustomFieldsInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerEarnedBadgesInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerJoinedQuestInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerPointInfoInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerPrivateInfoInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerQuestInfoInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerRankingInteractor;
import com.playbasis.pbcore.domain.interactor.player.PlayerAuthenticationInteractor;
import com.playbasis.pbcore.domain.interactor.player.RegisterPlayerInteractor;
import com.playbasis.pbcore.domain.interactor.player.RequestOTPCodeInteractor;
import com.playbasis.pbcore.domain.interactor.player.SendPlayerEmailVerificationInteractor;
import com.playbasis.pbcore.domain.interactor.player.SetPlayerCustomFieldsInteractor;
import com.playbasis.pbcore.domain.interactor.player.UpdatePlayerInteractor;
import com.playbasis.pbcore.domain.interactor.player.UpdatePlayerOrganizableModelInteractor;
import com.playbasis.pbcore.domain.interactor.player.VerifyOTPCodeInteractor;
import com.playbasis.pbcore.rest.RestClient;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tar on 5/5/16 AD.
 */
@Module
public class PlayerModule {

  @Provides
  @PerActivity
  RegisterPlayerInteractor provideRegisterUserInteractor(PBThreadExecutor threadExecutor,
                                                         PBPostExecutionThread postExecutionThread,
                                                         RestClient restClient,
                                                         RequestTokenInteractor requestTokenInteractor) {
    return new RegisterPlayerInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  SendPlayerEmailVerificationInteractor provideVerifyUserEmailInteractor(PBThreadExecutor threadExecutor,
                                                                         PBPostExecutionThread postExecutionThread,
                                                                         RestClient restClient,
                                                                         RequestTokenInteractor requestTokenInteractor) {
    return new SendPlayerEmailVerificationInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  ForgetPasswordInteractor provideForgetPasswordInteractor(PBThreadExecutor threadExecutor,
                                                           PBPostExecutionThread postExecutionThread,
                                                           RestClient restClient,
                                                           RequestTokenInteractor requestTokenInteractor) {
    return new ForgetPasswordInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  PlayerAuthenticationInteractor providePlayerAuthenticationInteractor(PBThreadExecutor threadExecutor,
                                                                       PBPostExecutionThread postExecutionThread,
                                                                       RestClient restClient,
                                                                       RequestTokenInteractor requestTokenInteractor) {
    return new PlayerAuthenticationInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  GetPlayerPrivateInfoInteractor provideGetPlayerPrivateInfoInteractor(PBThreadExecutor threadExecutor,
                                                                       PBPostExecutionThread postExecutionThread,
                                                                       RestClient restClient,
                                                                       RequestTokenInteractor requestTokenInteractor) {
    return new GetPlayerPrivateInfoInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  GetPlayerCustomFieldsInteractor provideGetUserCustomFieldsInteractor(PBThreadExecutor threadExecutor,
                                                                       PBPostExecutionThread postExecutionThread,
                                                                       RestClient restClient,
                                                                       RequestTokenInteractor requestTokenInteractor) {
    return new GetPlayerCustomFieldsInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  UpdatePlayerInteractor provideUpdateUserInteractor(PBThreadExecutor threadExecutor,
                                                     PBPostExecutionThread postExecutionThread,
                                                     RestClient restClient,
                                                     RequestTokenInteractor requestTokenInteractor) {
    return new UpdatePlayerInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  SetPlayerCustomFieldsInteractor provideSetUserCustomFieldInteractor(PBThreadExecutor threadExecutor,
                                                                      PBPostExecutionThread postExecutionThread,
                                                                      RestClient restClient,
                                                                      RequestTokenInteractor requestTokenInteractor) {
    return new SetPlayerCustomFieldsInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  UpdatePlayerOrganizableModelInteractor provideUpdateUserOrganizableModelInteractor(PBThreadExecutor threadExecutor,
                                                                                     PBPostExecutionThread postExecutionThread,
                                                                                     RestClient restClient,
                                                                                     RequestTokenInteractor requestTokenInteractor) {
    return new UpdatePlayerOrganizableModelInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  GetPlayerEarnedBadgesInteractor provideGetPlayerEarnedBadgesInteractor(PBThreadExecutor threadExecutor,
                                                                         PBPostExecutionThread postExecutionThread,
                                                                         RestClient restClient,
                                                                         RequestTokenInteractor requestTokenInteractor) {
    return new GetPlayerEarnedBadgesInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  GetPlayerAllBadgesInteractor provideGetPlayerAllBadgesInteractor(PBThreadExecutor threadExecutor,
                                                                   PBPostExecutionThread postExecutionThread,
                                                                   RestClient restClient,
                                                                   RequestTokenInteractor requestTokenInteractor) {
    return new GetPlayerAllBadgesInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  GetPlayerAllGoodsInteractor provideGetPlayerAllGoodsInteractor(PBThreadExecutor threadExecutor,
                                                                 PBPostExecutionThread postExecutionThread,
                                                                 RestClient restClient,
                                                                 RequestTokenInteractor requestTokenInteractor) {
    return new GetPlayerAllGoodsInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  GetPlayerAllQuestInteractor provideGetPlayerAllQuestInteractor(PBThreadExecutor threadExecutor,
                                                                 PBPostExecutionThread postExecutionThread,
                                                                 RestClient restClient,
                                                                 RequestTokenInteractor requestTokenInteractor) {
    return new GetPlayerAllQuestInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  GetPlayerJoinedQuestInteractor provideGetPlayerJoinedQuestInteractor(PBThreadExecutor threadExecutor,
                                                                       PBPostExecutionThread postExecutionThread,
                                                                       RestClient restClient,
                                                                       RequestTokenInteractor requestTokenInteractor) {
    return new GetPlayerJoinedQuestInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  GetPlayerQuestInfoInteractor provideGetPlayerQuestInfoInteractor(PBThreadExecutor threadExecutor,
                                                                   PBPostExecutionThread postExecutionThread,
                                                                   RestClient restClient,
                                                                   RequestTokenInteractor requestTokenInteractor) {
    return new GetPlayerQuestInfoInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  GetPlayerAllPointsInteractor provideGetPlayerAllPointsInteractor(PBThreadExecutor threadExecutor,
                                                                   PBPostExecutionThread postExecutionThread,
                                                                   RestClient restClient,
                                                                   RequestTokenInteractor requestTokenInteractor) {
    return new GetPlayerAllPointsInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  GetPlayerPointInfoInteractor provideGetPlayerPointInfoInteractor(PBThreadExecutor threadExecutor,
                                                                   PBPostExecutionThread postExecutionThread,
                                                                   RestClient restClient,
                                                                   RequestTokenInteractor requestTokenInteractor) {
    return new GetPlayerPointInfoInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  GetPlayerRankingInteractor provideGetPlayerRankingInteractor(PBThreadExecutor threadExecutor,
                                                               PBPostExecutionThread postExecutionThread,
                                                               RestClient restClient,
                                                               RequestTokenInteractor requestTokenInteractor) {
    return new GetPlayerRankingInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  RequestOTPCodeInteractor provideRequestOTPCodeInteractor(PBThreadExecutor threadExecutor,
                                                           PBPostExecutionThread postExecutionThread,
                                                           RestClient restClient,
                                                           RequestTokenInteractor requestTokenInteractor) {
    return new RequestOTPCodeInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  VerifyOTPCodeInteractor provideVerifyOTPCodeInteractor(PBThreadExecutor threadExecutor,
                                                         PBPostExecutionThread postExecutionThread,
                                                         RestClient restClient,
                                                         RequestTokenInteractor requestTokenInteractor) {
    return new VerifyOTPCodeInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }
}
