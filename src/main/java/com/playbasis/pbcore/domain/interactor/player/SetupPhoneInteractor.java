package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.SetupPhoneForm;
import com.playbasis.pbcore.rest.result.player.SetupPhoneApiResult;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class SetupPhoneInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "SetupPhoneInteractor";

  protected SetupPhoneForm setupPhoneForm;

  @Inject
  public SetupPhoneInteractor(PBThreadExecutor threadExecutor,
                              PBPostExecutionThread postExecutionThread,
                              RestClient restClient,
                              RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .setupPhone(
            setupPhoneForm.getPlayerId(),
            getApiToken(),
            setupPhoneForm.getPhoneNumber(),
            setupPhoneForm.getFields()
        ).map(new PBApiErrorCheckFunc<SetupPhoneApiResult>());
  }

  public void setSetupPhoneForm(SetupPhoneForm setupPhoneForm) {
    this.setupPhoneForm = setupPhoneForm;
  }
}
