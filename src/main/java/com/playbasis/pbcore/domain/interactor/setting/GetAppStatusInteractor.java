package com.playbasis.pbcore.domain.interactor.setting;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.setting.AppStatusForm;
import com.playbasis.pbcore.rest.result.setting.AppStatusApiResult;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetAppStatusInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetRecentActivitiesInteractor";

  protected AppStatusForm appStatusForm;

  @Inject
  public GetAppStatusInteractor(PBThreadExecutor threadExecutor,
                                PBPostExecutionThread postExecutionThread,
                                RestClient restClient,
                                RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getSettingService()
        .getAppStatus(
            getApiKey(),
            appStatusForm.getFields()

        ).map(new PBApiErrorCheckFunc<AppStatusApiResult>());
  }

  public void setAppStatusForm(AppStatusForm appStatusForm) {
    this.appStatusForm = appStatusForm;
  }
}
