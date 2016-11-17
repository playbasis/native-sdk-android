package com.playbasis.pbcore.domain.interactor.point;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.RemainingPoint;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.point.RetrieveRemainingPointsForm;
import com.playbasis.pbcore.rest.result.point.RemainingPointApiResult;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Nott on 16/11/2559.
 * playbasis-sdk-android-project
 */

public class GetRemainingPointsInteractor extends PlayBasisApiInteractor {
  public static final String TAG = "GetRemainingPointsInter";

  private RetrieveRemainingPointsForm form;

  @Inject
  public GetRemainingPointsInteractor(PBThreadExecutor threadExecutor,
                                      PBPostExecutionThread postExecutionThread,
                                      RestClient restClient,
                                      RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPointService()
        .getRemainingPoints(form.getName(), getApiKey())
        .map(new PBApiErrorCheckFunc<RemainingPointApiResult>())
        .map(getResultRemainingPointsFunction());
  }

  public void setForm(RetrieveRemainingPointsForm form) {
    this.form = form;
  }

  public Func1<RemainingPointApiResult, List<? extends RemainingPoint>> getResultRemainingPointsFunction() {
    return new Func1<RemainingPointApiResult, List<? extends RemainingPoint>>() {
      @Override
      public List<? extends RemainingPoint> call(RemainingPointApiResult remainingPointApiResult) {
        if (remainingPointApiResult == null) {
          return null;
        }

        List<RemainingPoint> points = new ArrayList<>();
        for (int i = 0; i < remainingPointApiResult.response.size(); i++) {
          points.add(new RemainingPoint(remainingPointApiResult.response.get(i).name,
              remainingPointApiResult.response.get(i).quantity));
        }
        return points;
      }
    };
  }
}
