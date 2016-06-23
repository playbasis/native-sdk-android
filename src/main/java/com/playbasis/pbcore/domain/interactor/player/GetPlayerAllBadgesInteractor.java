package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Badge;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.GetPlayerBadgesForm;
import com.playbasis.pbcore.rest.result.player.GetPlayerBadgesApiResult;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetPlayerAllBadgesInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetIdeasInteractor";

  private GetPlayerBadgesForm getPlayerBadgesForm;

  @Inject
  public GetPlayerAllBadgesInteractor(ThreadExecutor threadExecutor,
                                      PostExecutionThread postExecutionThread,
                                      RestClient restClient,
                                      RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .getPlayerAllBadges(
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
