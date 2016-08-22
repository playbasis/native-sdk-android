package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Player;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.GetPlayerCustomFieldForm;
import com.playbasis.pbcore.rest.result.player.GetUserCustomFieldsApiResult;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetPlayerCustomFieldsInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetPlayerCustomFieldsInteractor";

  protected GetPlayerCustomFieldForm getPlayerCustomFieldForm;

  @Inject
  public GetPlayerCustomFieldsInteractor(PBThreadExecutor threadExecutor,
                                         PBPostExecutionThread postExecutionThread,
                                         RestClient restClient,
                                         RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    Observable observable = restClient.getPlayerService()
        .getPlayerCustomFields(
            getPlayerCustomFieldForm.getPlayerId(),
            getApiKey(),
            getPlayerCustomFieldForm.getFields()

        ).map(new PBApiErrorCheckFunc<GetUserCustomFieldsApiResult>());

    if (getPlayerCustomFieldForm.getPlayer() != null) {
      observable = observable.map(getResultMapFunction());
    }

    return observable;
  }

  public void setGetPlayerCustomFieldForm(GetPlayerCustomFieldForm getPlayerCustomFieldForm) {
    this.getPlayerCustomFieldForm = getPlayerCustomFieldForm;
  }

  public Func1<GetUserCustomFieldsApiResult, Player> getResultMapFunction() {
    return new Func1<GetUserCustomFieldsApiResult, Player>() {
      @Override
      public Player call(GetUserCustomFieldsApiResult getUserCustomFieldsApiResult) {
        Player player = getPlayerCustomFieldForm.getPlayer();
        player.update(getUserCustomFieldsApiResult);

        return player;
      }
    };
  }
}
