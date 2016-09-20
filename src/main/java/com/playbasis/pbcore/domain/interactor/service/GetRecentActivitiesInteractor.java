package com.playbasis.pbcore.domain.interactor.service;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.RecentActivity;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.service.RecentActivitiesForm;
import com.playbasis.pbcore.rest.result.service.RecentActivitiesApiResult;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetRecentActivitiesInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetRecentActivitiesInteractor";

  protected RecentActivitiesForm recentActivitiesForm;

  @Inject
  public GetRecentActivitiesInteractor(PBThreadExecutor threadExecutor,
                                       PBPostExecutionThread postExecutionThread,
                                       RestClient restClient,
                                       RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getServiceService()
        .recentActivities(
            getApiKey(),
            recentActivitiesForm.getFields()

        ).map(new PBApiErrorCheckFunc<RecentActivitiesApiResult>())
        .map(getResultMapFunction());
  }

  public void setRecentActivitiesForm(RecentActivitiesForm recentActivitiesForm) {
    this.recentActivitiesForm = recentActivitiesForm;
  }

  public Func1<RecentActivitiesApiResult, List<RecentActivity>> getResultMapFunction() {
    return new Func1<RecentActivitiesApiResult, List<RecentActivity>>() {
      @Override
      public List<RecentActivity> call(RecentActivitiesApiResult recentActivitiesApiResult) {
        return RecentActivity.createRecentActivities(recentActivitiesApiResult.getResponses());
      }
    };
  }
}
