package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Point;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.GetPlayerPointInfoForm;
import com.playbasis.pbcore.rest.result.player.PlayerPointApiResult;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetPlayerPointInfoInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetPlayerAllPointsInteractor";

  private GetPlayerPointInfoForm getPlayerPointInfoForm;

  @Inject
  public GetPlayerPointInfoInteractor(ThreadExecutor threadExecutor,
                                      PostExecutionThread postExecutionThread,
                                      RestClient restClient,
                                      RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .getPlayerPoint(
            getPlayerPointInfoForm.getPlayerId(),
            getPlayerPointInfoForm.getPointName(),
            getApiKey()
        )
        .map(new PBApiErrorCheckFunc<PlayerPointApiResult>())
        .map(getResultMapFunction());
  }

  public void setGetPlayerPointInfoForm(GetPlayerPointInfoForm getPlayerPointInfoForm) {
    this.getPlayerPointInfoForm = getPlayerPointInfoForm;
  }

  public Func1<PlayerPointApiResult, ? extends Point> getResultMapFunction() {
    return new Func1<PlayerPointApiResult, Point>() {
      @Override
      public Point call(PlayerPointApiResult playerPointApiResult) {
        return new Point(playerPointApiResult.response);
      }
    };
  }
}
