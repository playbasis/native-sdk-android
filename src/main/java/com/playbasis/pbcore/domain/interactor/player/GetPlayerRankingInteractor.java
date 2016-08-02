package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.PlayerRank;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.GetPlayerRankingForm;
import com.playbasis.pbcore.rest.result.player.PlayerRankApiResult;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetPlayerRankingInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetPlayerAllPointsInteractor";

  private GetPlayerRankingForm getPlayerRankingForm;

  @Inject
  public GetPlayerRankingInteractor(ThreadExecutor threadExecutor,
                                    PostExecutionThread postExecutionThread,
                                    RestClient restClient,
                                    RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .getPlayerRanking(
            getPlayerRankingForm.getRankBy(),
            getPlayerRankingForm.getLimit(),
            getApiKey()
        )
        .map(new PBApiErrorCheckFunc<PlayerRankApiResult>())
        .map(getResultMapFunction());
  }

  public void setGetPlayerRankingForm(GetPlayerRankingForm getPlayerRankingForm) {
    this.getPlayerRankingForm = getPlayerRankingForm;
  }

  public Func1<PlayerRankApiResult, List<? extends PlayerRank>> getResultMapFunction() {
    return new Func1<PlayerRankApiResult, List<? extends PlayerRank>>() {
      @Override
      public List<? extends PlayerRank> call(PlayerRankApiResult playerPointApiResult) {
        return PlayerRank.createPlayerRanks(playerPointApiResult.response);
      }
    };
  }
}
