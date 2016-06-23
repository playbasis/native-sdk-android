package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.domain.model.Badge;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.GetPlayerBadgesForm;
import com.playbasis.pbcore.rest.result.GetPlayerBadgesApiResult;
import com.playbasis.pbcore.rest.result.function.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetPlayerEarnedBadgesInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetIdeasInteractor";

  private GetPlayerBadgesForm getPlayerBadgesForm;

  @Inject
  public GetPlayerEarnedBadgesInteractor(ThreadExecutor threadExecutor,
                                         PostExecutionThread postExecutionThread,
                                         RestClient restClient,
                                         RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .getPlayerEarnedBadges(
            getPlayerBadgesForm.getPlayerId(),
            getApiKey()
        )
        .map(new PBApiErrorCheckFunc<GetPlayerBadgesApiResult>())
        .map(new Func1<GetPlayerBadgesApiResult, ArrayList<Badge>>() {
          @Override
          public ArrayList<Badge> call(GetPlayerBadgesApiResult getPlayerBadgesApiResult) {
            return Badge.create(getPlayerBadgesApiResult.response);
          }
        });
  }

  public void setGetPlayerBadgesForm(GetPlayerBadgesForm getPlayerBadgesForm) {
    this.getPlayerBadgesForm = getPlayerBadgesForm;
  }
}
