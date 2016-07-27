package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.PlayerAuthenticationForm;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class PlayerAuthenticationInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "PlayerAuthenticationInteractor";

  protected PlayerAuthenticationForm mPlayerAuthenticationForm;

  @Inject
  public PlayerAuthenticationInteractor(ThreadExecutor threadExecutor,
                                        PostExecutionThread postExecutionThread,
                                        RestClient restClient,
                                        RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .loginPlayer(
            getApiToken(),
            mPlayerAuthenticationForm.getEmail(),
            mPlayerAuthenticationForm.getUserName(),
            mPlayerAuthenticationForm.getPassword()
        );
  }

  public void setPlayerAuthenticationForm(PlayerAuthenticationForm playerAuthenticationForm) {
    mPlayerAuthenticationForm = playerAuthenticationForm;
  }
}
