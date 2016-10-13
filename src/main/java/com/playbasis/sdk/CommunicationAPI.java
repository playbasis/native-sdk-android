package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerCommunicationAPIComponent;
import com.playbasis.pbcore.dependency.module.CommunicationModule;
import com.playbasis.pbcore.domain.interactor.communication.DeviceRegistrationInteractor;
import com.playbasis.pbcore.domain.interactor.communication.SendEmailCouponInteractor;
import com.playbasis.pbcore.domain.interactor.communication.SendEmailInteractor;
import com.playbasis.pbcore.rest.result.communication.SendEmailApiResult;
import com.playbasis.pbcore.rest.result.communication.SendEmailCouponApiResult;
import com.playbasis.sdk.callback.BasicApiCallback;
import com.playbasis.sdk.callback.BasicApiCallbackWithResult;
import com.playbasis.sdk.subscriber.BaseApiSubscriber;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Tar on 8/19/16 AD.
 */
public class CommunicationAPI {

  private static CommunicationAPI communicationAPI;

  @Inject
  protected SendEmailInteractor sendEmailInteractor;
  @Inject
  protected SendEmailCouponInteractor sendEmailCouponInteractor;
  @Inject
  protected DeviceRegistrationInteractor deviceRegistrationInteractor;

  public static CommunicationAPI instance() {
    if (communicationAPI == null) {
      communicationAPI = new CommunicationAPI();

      DaggerCommunicationAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .communicationModule(new CommunicationModule())
          .build()
          .inject(communicationAPI);
    }

    return communicationAPI;
  }

  public static void sendEmail(SendEmailForm form, final SendEmailCallback callback) {
    instance().sendEmailInteractor.setSendEmailForm(form);
    instance().sendEmailInteractor.execute(new BaseApiSubscriber<SendEmailApiResult>(callback) {
      @Override
      public void onCompleted() {
        if (callback != null) {
          callback.onSuccess(resultObj.response);
        }
      }
    });
  }

  public static void sendEmailCoupon(SendEmailCouponForm form, final SendEmailCouponCallback callback) {
    instance().sendEmailCouponInteractor.setSendEmailCouponForm(form);
    instance().sendEmailCouponInteractor.execute(new BaseApiSubscriber<SendEmailCouponApiResult>(callback) {
      @Override
      public void onCompleted() {
        if (callback != null) {
          callback.onSuccess(resultObj.response);
        }
      }
    });
  }

  public static void deviceRegistration(DeviceRegistrationForm form, DeviceRegistrationCallback callback) {
    instance().deviceRegistrationInteractor.setDeviceRegistrationForm(form);
    instance().deviceRegistrationInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static class SendEmailForm extends com.playbasis.pbcore.rest.form.communication.SendEmailForm {

    public SendEmailForm(String playerId, String subject) {
      super(playerId, subject);
    }
  }

  public static class SendEmailCouponForm extends com.playbasis.pbcore.rest.form.communication.SendEmailCouponForm {

    public SendEmailCouponForm(String playerId, String subject, String refId) {
      super(playerId, subject, refId);
    }
  }

  public static class DeviceRegistrationForm extends com.playbasis.pbcore.rest.form.communication.DeviceRegistrationForm {

    public DeviceRegistrationForm(String playerId, String deviceToken, String deviceDescription, String deviceName) {
      super(playerId, deviceToken, deviceDescription, deviceName);
    }
  }

  public interface SendEmailCallback extends BasicApiCallbackWithResult<List<String>> {

  }

  public interface SendEmailCouponCallback extends BasicApiCallbackWithResult<List<String>> {

  }

  public interface DeviceRegistrationCallback extends BasicApiCallback {

  }
}
