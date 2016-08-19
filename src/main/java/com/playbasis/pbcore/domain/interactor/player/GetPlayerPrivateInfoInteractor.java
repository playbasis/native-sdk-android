package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Player;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.GetPlayerForm;
import com.playbasis.pbcore.rest.result.player.GetPlayerDetailApiResult;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetPlayerPrivateInfoInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetPlayerPrivateInfoInteractor";

  protected GetPlayerForm getPlayerForm;

  @Inject
  public GetPlayerPrivateInfoInteractor(PBThreadExecutor threadExecutor,
                                        PBPostExecutionThread postExecutionThread,
                                        RestClient restClient,
                                        RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .getPlayerPrivateInfo(
            getPlayerForm.getPlayerId(),
            getApiToken(),
            getPlayerForm.getFields()
        ).map(new PBApiErrorCheckFunc<GetPlayerDetailApiResult>())
        .map(getResultMapFunction());
  }

  public Func1<GetPlayerDetailApiResult, Player> getResultMapFunction() {
    return new Func1<GetPlayerDetailApiResult, Player>() {
      @Override
      public Player call(GetPlayerDetailApiResult getPlayerDetailApiResult) {
        Player player = new Player(getPlayerForm.getPlayerId());
        player.update(getPlayerDetailApiResult.getPlayerResponse());
        return player;
      }
    };
  }

  public void setGetPlayerForm(GetPlayerForm getPlayerForm) {
    this.getPlayerForm = getPlayerForm;
  }
}
