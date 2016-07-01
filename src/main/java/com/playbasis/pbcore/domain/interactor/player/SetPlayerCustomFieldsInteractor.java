package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.UpdatePlayerCustomFieldForm;
import com.playbasis.pbcore.rest.result.player.SetPlayerCustomFieldApiResult;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class SetPlayerCustomFieldsInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "SetPlayerCustomFieldsInteractor";

  private UpdatePlayerCustomFieldForm form;

  @Inject
  public SetPlayerCustomFieldsInteractor(ThreadExecutor threadExecutor,
                                         PostExecutionThread postExecutionThread,
                                         RestClient restClient,
                                         RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .setPlayerCustomFields(
            form.getPlayerId(),
            getApiToken(),
            form.getKeys(),
            form.getValues()
        ).map(new PBApiErrorCheckFunc<SetPlayerCustomFieldApiResult>());
  }

  public void setCurtomFieldForm(UpdatePlayerCustomFieldForm curtomFieldForm) {
    this.form = curtomFieldForm;
  }
}
