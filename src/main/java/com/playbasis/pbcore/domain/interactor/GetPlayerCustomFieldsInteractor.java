package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.domain.model.Player;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.GetPlayerCustomFieldForm;
import com.playbasis.pbcore.rest.result.GetUserCustomFieldsApiResult;
import com.playbasis.pbcore.rest.result.function.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;
import com.smartsoftasia.ssalibrary.helper.Validator;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetPlayerCustomFieldsInteractor extends PlayBasisApiInteractor {

  GetPlayerCustomFieldForm getPlayerCustomFieldForm;

  @Inject
  public GetPlayerCustomFieldsInteractor(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                                         RestClient restClient, RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    final Player player = getPlayerCustomFieldForm.getPlayer();
    if (player == null || !Validator.isValid(player.getPlayerId())) {
      return Observable.just(player);
    }

    return restClient.getPlayerService()
        .getPlayerCustomFields(
            player.getPlayerId(),
            getApiKey()
        ).map(new PBApiErrorCheckFunc<GetUserCustomFieldsApiResult>())
        .map(new Func1<GetUserCustomFieldsApiResult, Player>() {
          @Override
          public Player call(GetUserCustomFieldsApiResult getUserCustomFieldsApiResult) {
            if (getUserCustomFieldsApiResult != null) {
              player.update(getUserCustomFieldsApiResult);
            }

            return player;
          }
        });
  }

  public void setGetPlayerCustomFieldForm(GetPlayerCustomFieldForm getPlayerCustomFieldForm) {
    this.getPlayerCustomFieldForm = getPlayerCustomFieldForm;
  }
}
