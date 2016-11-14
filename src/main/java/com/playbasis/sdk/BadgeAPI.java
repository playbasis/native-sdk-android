package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerBadgeAPIComponent;
import com.playbasis.pbcore.dependency.module.BadgeModule;
import com.playbasis.pbcore.domain.interactor.badge.GetAllBadgesInteractor;
import com.playbasis.pbcore.domain.model.Badge;
import com.playbasis.pbcore.rest.form.badge.GetAllBadgesForm;
import com.playbasis.sdk.callback.BasicApiCallbackWithResult;
import com.playbasis.sdk.subscriber.BaseApiSubscriber;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Tar on 8/19/16 AD.
 */
public class BadgeAPI {

  private static BadgeAPI badgeAPI;

  @Inject
  GetAllBadgesInteractor getAllBadgesInteractor;

  public static BadgeAPI instance() {
    if (badgeAPI == null) {
      badgeAPI = new BadgeAPI();

      DaggerBadgeAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .badgeModule(new BadgeModule())
          .build()
          .inject(badgeAPI);
    }

    return badgeAPI;
  }

  public static void badgeInfo(BadgesInfoForm form, BadgesInfoCallback callback) {
    instance().getAllBadgesInteractor.setGetAllBadgesForm(form);
    instance().getAllBadgesInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static class BadgesInfoForm extends GetAllBadgesForm {

  }

  public interface BadgesInfoCallback extends BasicApiCallbackWithResult<List<Badge>> {

  }
}
