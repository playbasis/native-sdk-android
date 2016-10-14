package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerSettingAPIComponent;
import com.playbasis.pbcore.dependency.module.SettingModule;
import com.playbasis.pbcore.domain.interactor.setting.GetAppStatusInteractor;
import com.playbasis.pbcore.rest.result.setting.AppStatusApiResult;
import com.playbasis.pbcore.rest.result.setting.AppStatusApiResult.AppPeriodResponse;
import com.playbasis.sdk.callback.BaseApiCallback;
import com.playbasis.sdk.subscriber.BaseApiSubscriber;

import java.util.Date;

import javax.inject.Inject;

/**
 * Created by Tar on 8/19/16 AD.
 */
public class SettingAPI {

  private static SettingAPI settingAPI;

  @Inject
  protected GetAppStatusInteractor getAppStatusInteractor;

  public static SettingAPI instance() {
    if (settingAPI == null) {
      settingAPI = new SettingAPI();

      DaggerSettingAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .settingModule(new SettingModule())
          .build()
          .inject(settingAPI);
    }

    return settingAPI;
  }

  public static void appStatus(AppStatusForm form, final AppStatusCallback callback) {
    instance().getAppStatusInteractor.setAppStatusForm(form);
    instance().getAppStatusInteractor.execute(new BaseApiSubscriber<AppStatusApiResult>(callback) {
      @Override
      public void onCompleted() {
        super.onCompleted();

        if (callback != null) {
          AppPeriodResponse appPeriodResponse = resultObj.getAppPeriodResponse();

          if (appPeriodResponse != null) {
            callback.onSuccess(resultObj.success, appPeriodResponse.dateStart, appPeriodResponse.dateEnd);
          } else {
            callback.onSuccess(resultObj.success, null, null);
          }
        }
      }
    });
  }

  public static class AppStatusForm extends com.playbasis.pbcore.rest.form.setting.AppStatusForm {

  }

  public interface AppStatusCallback extends BaseApiCallback {

    void onSuccess(boolean appStatus, Date dateStart, Date dateEnd);
  }
}
