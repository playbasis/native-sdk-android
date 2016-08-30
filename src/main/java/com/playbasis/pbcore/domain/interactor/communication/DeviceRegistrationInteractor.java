package com.playbasis.pbcore.domain.interactor.communication;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.communication.DeviceRegistrationForm;
import com.playbasis.pbcore.rest.result.communication.DeviceRegistrationApiResult;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class DeviceRegistrationInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "RuleInteractor";

  protected DeviceRegistrationForm deviceRegistrationForm;

  @Inject
  public DeviceRegistrationInteractor(PBThreadExecutor threadExecutor,
                                      PBPostExecutionThread postExecutionThread,
                                      RestClient restClient,
                                      RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getCommunicationService()
        .deviceRegistration(
            getApiToken(),
            deviceRegistrationForm.getPlayerId(),
            deviceRegistrationForm.getDeviceToken(),
            deviceRegistrationForm.getDeviceName(),
            deviceRegistrationForm.getDeviceDescription(),
            deviceRegistrationForm.getOSType(),
            deviceRegistrationForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<DeviceRegistrationApiResult>());
  }

  public void setDeviceRegistrationForm(DeviceRegistrationForm deviceRegistrationForm) {
    this.deviceRegistrationForm = deviceRegistrationForm;
  }
}
