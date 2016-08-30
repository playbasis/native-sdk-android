package com.playbasis.pbcore.dependency.module;

import com.playbasis.pbcore.dependency.component.PerActivity;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.interactor.communication.DeviceRegistrationInteractor;
import com.playbasis.pbcore.domain.interactor.communication.SendEmailCouponInteractor;
import com.playbasis.pbcore.domain.interactor.communication.SendEmailInteractor;
import com.playbasis.pbcore.rest.RestClient;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tar on 4/21/16 AD.
 */
@Module
public class CommunicationModule {

  @Provides
  @PerActivity
  SendEmailInteractor provideSendEmailInteractor(PBThreadExecutor threadExecutor,
                                                 PBPostExecutionThread postExecutionThread,
                                                 RestClient restClient,
                                                 RequestTokenInteractor requestTokenInteractor) {
    return new SendEmailInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  SendEmailCouponInteractor provideSendEmailCouponInteractor(PBThreadExecutor threadExecutor,
                                                             PBPostExecutionThread postExecutionThread,
                                                             RestClient restClient,
                                                             RequestTokenInteractor requestTokenInteractor) {
    return new SendEmailCouponInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Provides
  @PerActivity
  DeviceRegistrationInteractor provideDeviceRegistrationInteractor(PBThreadExecutor threadExecutor,
                                                                   PBPostExecutionThread postExecutionThread,
                                                                   RestClient restClient,
                                                                   RequestTokenInteractor requestTokenInteractor) {
    return new DeviceRegistrationInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }
}
