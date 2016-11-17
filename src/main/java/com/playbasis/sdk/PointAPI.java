package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerPointAPIComponent;
import com.playbasis.pbcore.domain.interactor.point.GetRemainingPointsInteractor;
import com.playbasis.pbcore.domain.model.RemainingPoint;
import com.playbasis.sdk.callback.BasicApiCallbackWithResult;
import com.playbasis.sdk.subscriber.BaseApiSubscriber;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Nott on 16/11/2559.
 * playbasis-sdk-android-project
 */

public class PointAPI {
  private static PointAPI pointAPI;

  @Inject
  protected GetRemainingPointsInteractor getRemainingPointsInteractor;

  public static PointAPI instance() {
    if (pointAPI == null) {
      pointAPI = new PointAPI();

      DaggerPointAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .build()
          .inject(pointAPI);
    }

    return pointAPI;
  }

  public static void retrieveRemainingPoints(RetrieveRemainingPointsForm form, RetrieveRemainingPointsCallback callback) {
    instance().getRemainingPointsInteractor.setForm(form);
    instance().getRemainingPointsInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static class RetrieveRemainingPointsForm extends com.playbasis.pbcore.rest.form.point.RetrieveRemainingPointsForm {

  }

  public interface RetrieveRemainingPointsCallback extends BasicApiCallbackWithResult<List<RemainingPoint>> {

  }
}
