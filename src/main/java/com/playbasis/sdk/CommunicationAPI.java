package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerCommunicationAPIComponent;
import com.playbasis.pbcore.dependency.module.CommunicationModule;
import com.playbasis.pbcore.domain.interactor.communication.SendEmailInteractor;
import com.playbasis.pbcore.rest.result.communication.SendEmailApiResult;
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
    instance().sendEmailInteractor.execute(new BaseApiSubscriber<SendEmailApiResult>(callback){
      @Override
      public void onCompleted() {
        if (callback != null) {
          callback.onSuccess(resultObj.response);
        }
      }
    });
  }

  public static class SendEmailForm extends com.playbasis.pbcore.rest.form.communication.SendEmailForm {

    public SendEmailForm(String playerId, String subject, String message) {
      super(playerId, subject, message);
    }
  }

  public interface SendEmailCallback extends BasicApiCallbackWithResult<List<String>> {

  }
}
