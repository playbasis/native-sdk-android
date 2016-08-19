package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.PlayerAuthenticationForm;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class PlayerAuthenticationInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "PlayerAuthenticationInteractor";

  protected PlayerAuthenticationForm mPlayerAuthenticationForm;

  @Inject
  public PlayerAuthenticationInteractor(PBThreadExecutor threadExecutor,
                                        PBPostExecutionThread postExecutionThread,
                                        RestClient restClient,
                                        RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .loginPlayer(
            getApiToken(),
            mPlayerAuthenticationForm.getPassword(),
            mPlayerAuthenticationForm.getFields()
        );
  }

  public void setPlayerAuthenticationForm(PlayerAuthenticationForm playerAuthenticationForm) {
    mPlayerAuthenticationForm = playerAuthenticationForm;
  }
}
