package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.model.Player;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.GetPlayerCustomFieldForm;
import com.playbasis.pbcore.rest.form.player.GetPlayerForm;
import com.playbasis.pbcore.rest.result.player.GetPlayerDetailApiResult;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class GetPlayerInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetPlayerInteractor";

  protected GetPlayerForm getPlayerForm;
  protected GetPlayerCustomFieldsInteractor getPlayerCustomFieldsInteractor;

  @Inject
  public GetPlayerInteractor(ThreadExecutor threadExecutor,
                             PostExecutionThread postExecutionThread,
                             RestClient restClient,
                             RequestTokenInteractor requestTokenInteractor,
                             GetPlayerCustomFieldsInteractor getPlayerCustomFieldsInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

    this.getPlayerCustomFieldsInteractor = getPlayerCustomFieldsInteractor;
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .getPlayerDetail(
            getPlayerForm.getPlayerId(),
            getApiToken(),
            getPlayerForm.getFields()
        ).map(new PBApiErrorCheckFunc<GetPlayerDetailApiResult>())
        .map(new Func1<GetPlayerDetailApiResult, Player>() {
          @Override
          public Player call(GetPlayerDetailApiResult getPlayerDetailApiResult) {
            if (!getPlayerDetailApiResult.success) {
              return null;
            }

            Player player = createPlayer(getPlayerDetailApiResult);
            updatePlayer(player, getPlayerDetailApiResult);

            return player;
          }
        }).flatMap(new Func1<Player, Observable<Player>>() {
          @Override
          public Observable<Player> call(Player user) {
            getPlayerCustomFieldsInteractor.setGetPlayerCustomFieldForm(new GetPlayerCustomFieldForm(user));
            return getPlayerCustomFieldsInteractor.buildUseCaseObservable();
          }
        });
  }

  public Player createPlayer(GetPlayerDetailApiResult getPlayerDetailApiResult) {
    Player player = new Player(getPlayerForm.getPlayerId());
    return player;
  }

  public Player updatePlayer(Player player, GetPlayerDetailApiResult getPlayerDetailApiResult) {
    player.update(getPlayerDetailApiResult.response.PlayerResponse);

    return player;
  }

  public void setGetPlayerForm(GetPlayerForm getPlayerForm) {
    this.getPlayerForm = getPlayerForm;
  }
}
