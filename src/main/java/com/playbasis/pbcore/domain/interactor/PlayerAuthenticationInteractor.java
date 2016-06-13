package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.PlayerAuthenticationForm;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class PlayerAuthenticationInteractor extends PlayBasisApiInteractor {

  private PlayerAuthenticationForm mPlayerAuthenticationForm;

  @Inject
  public PlayerAuthenticationInteractor(ThreadExecutor threadExecutor,
                                        PostExecutionThread postExecutionThread,
                                        RestClient restClient,
                                        RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService().loginPlayer(token.token, mPlayerAuthenticationForm.email, mPlayerAuthenticationForm.password);
  }

  public void setPlayerAuthenticationForm(PlayerAuthenticationForm playerAuthenticationForm) {
    mPlayerAuthenticationForm = playerAuthenticationForm;
  }
}
