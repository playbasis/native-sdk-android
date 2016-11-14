package com.playbasis.pbcore.domain.interactor.badge;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Badge;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.badge.GetAllBadgesForm;
import com.playbasis.pbcore.rest.result.badge.AllBadgesApiResult;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetAllBadgesInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetPlayerAllBadgesInteractor";

  protected GetAllBadgesForm getAllBadgesForm;

  @Inject
  public GetAllBadgesInteractor(PBThreadExecutor threadExecutor,
                                PBPostExecutionThread postExecutionThread,
                                RestClient restClient,
                                RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getBadgeService()
        .getAllBadges(
            getApiKey(),
            getAllBadgesForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<AllBadgesApiResult>())
        .map(getResultMapFunction());
  }

  public void setGetAllBadgesForm(GetAllBadgesForm getAllBadgesForm) {
    this.getAllBadgesForm = getAllBadgesForm;
  }

  public Func1<AllBadgesApiResult, List<? extends Badge>> getResultMapFunction() {
    return new Func1<AllBadgesApiResult, List<? extends Badge>>() {
      @Override
      public List<? extends Badge> call(AllBadgesApiResult getPlayerBadgesApiResult) {
        return Badge.createBadges(getPlayerBadgesApiResult.getBadgesResponse());
      }
    };
  }
}
