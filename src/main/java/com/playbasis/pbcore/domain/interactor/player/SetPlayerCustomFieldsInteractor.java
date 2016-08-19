package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.UpdatePlayerCustomFieldForm;
import com.playbasis.pbcore.rest.result.player.SetPlayerCustomFieldApiResult;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class SetPlayerCustomFieldsInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "SetPlayerCustomFieldsInteractor";

  protected UpdatePlayerCustomFieldForm updatePlayerCustomFieldForm;

  @Inject
  public SetPlayerCustomFieldsInteractor(PBThreadExecutor threadExecutor,
                                         PBPostExecutionThread postExecutionThread,
                                         RestClient restClient,
                                         RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .setPlayerCustomFields(
            updatePlayerCustomFieldForm.getPlayerId(),
            getApiToken(),
            updatePlayerCustomFieldForm.getKeys(),
            updatePlayerCustomFieldForm.getValues(),
            updatePlayerCustomFieldForm.getFields()
        ).map(new PBApiErrorCheckFunc<SetPlayerCustomFieldApiResult>());
  }

  public void setCurtomFieldForm(UpdatePlayerCustomFieldForm curtomFieldForm) {
    this.updatePlayerCustomFieldForm = curtomFieldForm;
  }
}
