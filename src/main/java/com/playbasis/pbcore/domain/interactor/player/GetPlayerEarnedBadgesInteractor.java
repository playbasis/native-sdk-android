package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Badge;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.GetPlayerBadgesForm;
import com.playbasis.pbcore.rest.result.player.GetPlayerBadgesApiResult;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetPlayerEarnedBadgesInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetPlayerEarnedBadgesInteractor";

  protected GetPlayerBadgesForm getPlayerBadgesForm;

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
            getApiKey(),
            getPlayerBadgesForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<GetPlayerBadgesApiResult>())
        .map(getResultMapFunction());
  }

  public void setGetPlayerBadgesForm(GetPlayerBadgesForm getPlayerBadgesForm) {
    this.getPlayerBadgesForm = getPlayerBadgesForm;
  }

  public Func1<GetPlayerBadgesApiResult, List<? extends Badge>> getResultMapFunction() {
    return new Func1<GetPlayerBadgesApiResult, List<? extends Badge>>() {
      @Override
      public List<? extends Badge> call(GetPlayerBadgesApiResult getPlayerBadgesApiResult) {
        return Badge.createBadges(getPlayerBadgesApiResult.response);
      }
    };
  }
}
