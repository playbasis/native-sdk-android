package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Point;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.GetPlayerPointsForm;
import com.playbasis.pbcore.rest.result.player.PlayerPointsApiResult;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetPlayerAllPointsInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetPlayerAllPointsInteractor";

  private GetPlayerPointsForm getPlayerPointsForm;

  @Inject
  public GetPlayerAllPointsInteractor(PBThreadExecutor threadExecutor,
                                      PBPostExecutionThread postExecutionThread,
                                      RestClient restClient,
                                      RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .getPlayerAllPoints(
            getPlayerPointsForm.getPlayerId(),
            getApiKey(),
            getPlayerPointsForm.getFields()
        )
        .map(new PBApiErrorCheckFunc<PlayerPointsApiResult>())
        .map(getResultMapFunction());
  }

  public void setGetPlayerPointsForm(GetPlayerPointsForm getPlayerPointsForm) {
    this.getPlayerPointsForm = getPlayerPointsForm;
  }

  public Func1<PlayerPointsApiResult, List<? extends Point>> getResultMapFunction() {
    return new Func1<PlayerPointsApiResult, List<? extends Point>>() {
      @Override
      public List<? extends Point> call(PlayerPointsApiResult playerPointsApiResult) {
        return Point.createPoints(playerPointsApiResult.getPointResponses());
      }
    };
  }
}
