package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.domain.model.Player;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.GetPlayerCustomFieldForm;
import com.playbasis.pbcore.rest.form.GetPlayerForm;
import com.playbasis.pbcore.rest.result.GetPlayerDetailApiResult;
import com.playbasis.pbcore.rest.result.function.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetPlayerInteractor extends PlayBasisApiInteractor {

  private GetPlayerForm getPlayerForm;
  private GetPlayerCustomFieldInteractor getPlayerCustomFieldInteractor;

  @Inject
  public GetPlayerInteractor(ThreadExecutor threadExecutor,
                             PostExecutionThread postExecutionThread,
                             RestClient restClient,
                             RequestTokenInteractor requestTokenInteractor,
                             GetPlayerCustomFieldInteractor getPlayerCustomFieldInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

    this.getPlayerCustomFieldInteractor = getPlayerCustomFieldInteractor;
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService().getPlayerDetail(getPlayerForm.playerId, token.token)
        .map(new PBApiErrorCheckFunc<GetPlayerDetailApiResult>())
        .map(new Func1<GetPlayerDetailApiResult, Player>() {
          @Override
          public Player call(GetPlayerDetailApiResult getPlayerDetailApiResult) {
            if (!getPlayerDetailApiResult.success) {
              return null;
            }

            Player player = createPlayer(getPlayerDetailApiResult);
            player.update(getPlayerDetailApiResult.response.getPlayerInfoResponse);

            return player;
          }
        }).flatMap(new Func1<Player, Observable<Player>>() {
          @Override
          public Observable<Player> call(Player user) {
            getPlayerCustomFieldInteractor.setGetPlayerCustomFieldForm(new GetPlayerCustomFieldForm(user));
            return getPlayerCustomFieldInteractor.buildUseCaseObservable();
          }
        });
  }

  public Player createPlayer(GetPlayerDetailApiResult getPlayerDetailApiResult) {
    Player player = new Player(getPlayerForm.playerId);
    return player;
  }

  public void setGetPlayerForm(GetPlayerForm getPlayerForm) {
    this.getPlayerForm = getPlayerForm;
  }
}
