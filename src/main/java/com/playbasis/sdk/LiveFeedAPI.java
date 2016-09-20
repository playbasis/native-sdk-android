package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerServiceAPIComponent;
import com.playbasis.pbcore.dependency.module.ServiceModule;
import com.playbasis.pbcore.domain.interactor.service.GetRecentActivitiesInteractor;
import com.playbasis.pbcore.domain.model.RecentActivity;
import com.playbasis.sdk.callback.BasicApiCallbackWithResult;
import com.playbasis.sdk.subscriber.BaseApiSubscriber;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Tar on 8/19/16 AD.
 */
public class LiveFeedAPI {

  private static LiveFeedAPI liveFeedAPI;

  @Inject
  protected GetRecentActivitiesInteractor getRecentActivitiesInteractor;

  public static LiveFeedAPI instance() {
    if (liveFeedAPI == null) {
      liveFeedAPI = new LiveFeedAPI();

      DaggerServiceAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .serviceModule(new ServiceModule())
          .build()
          .inject(liveFeedAPI);
    }

    return liveFeedAPI;
  }

  public static void recentActivities(RecentActivitiesForm form, RecentActivitiesCallback callback) {
    instance().getRecentActivitiesInteractor.setRecentActivitiesForm(form);
    instance().getRecentActivitiesInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static class RecentActivitiesForm extends com.playbasis.pbcore.rest.form.service.RecentActivitiesForm {

  }

  public interface RecentActivitiesCallback extends BasicApiCallbackWithResult<List<RecentActivity>> {

  }
}
