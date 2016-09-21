package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerLinkAPIComponent;
import com.playbasis.pbcore.dependency.module.LinkModule;
import com.playbasis.pbcore.domain.interactor.Link.GenerateLinkInteractor;
import com.playbasis.pbcore.rest.result.Link.GenerateLinkApiResult;
import com.playbasis.sdk.callback.BaseApiCallback;
import com.playbasis.sdk.subscriber.BaseApiSubscriber;

import javax.inject.Inject;

/**
 * Created by Tar on 8/19/16 AD.
 */
public class LinkAPI {

  private static LinkAPI liveFeedAPI;

  @Inject
  protected GenerateLinkInteractor getRecentActivitiesInteractor;

  public static LinkAPI instance() {
    if (liveFeedAPI == null) {
      liveFeedAPI = new LinkAPI();

      DaggerLinkAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .linkModule(new LinkModule())
          .build()
          .inject(liveFeedAPI);
    }

    return liveFeedAPI;
  }

  public static void generateLink(GenerateLinkForm form, final GenerateLinkCallback callback) {
    instance().getRecentActivitiesInteractor.setGenerateLinkForm(form);
    instance().getRecentActivitiesInteractor.execute(new BaseApiSubscriber<GenerateLinkApiResult>(callback) {
      @Override
      public void onCompleted() {
        super.onCompleted();

        if (callback != null) {
          callback.onSuccess(resultObj.getLink());
        }
      }
    });
  }

  public static class GenerateLinkForm extends com.playbasis.pbcore.rest.form.Link.GenerateLinkForm {

  }

  public interface GenerateLinkCallback extends BaseApiCallback {
    void onSuccess(String link);
  }
}
