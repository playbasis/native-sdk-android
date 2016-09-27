package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.GetPlayerActionCountForm;
import com.playbasis.pbcore.rest.result.player.PlayerActionCountApiResult;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetPlayerActionCountInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "RequestOTPCodeInteractor";

  protected GetPlayerActionCountForm getPlayerActionCountForm;

  @Inject
  public GetPlayerActionCountInteractor(PBThreadExecutor threadExecutor,
                                        PBPostExecutionThread postExecutionThread,
                                        RestClient restClient,
                                        RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .actionCount(
            getPlayerActionCountForm.getPlayerId(),
            getPlayerActionCountForm.getActionName(),
            getApiKey(),
            getPlayerActionCountForm.getFields())
        .map(new PBApiErrorCheckFunc<PlayerActionCountApiResult>());
  }

  public void setGetPlayerActionCountForm(GetPlayerActionCountForm getPlayerActionCountForm) {
    this.getPlayerActionCountForm = getPlayerActionCountForm;
  }
}
