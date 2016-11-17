package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerGameAPIComponent;
import com.playbasis.pbcore.dependency.module.GameModule;
import com.playbasis.pbcore.domain.interactor.game.GetGameSettingInteractor;
import com.playbasis.pbcore.domain.model.GameSetting;
import com.playbasis.pbcore.domain.model.RemainingPoint;
import com.playbasis.pbcore.rest.form.game.RetrieveGameSettingsForm;
import com.playbasis.sdk.callback.BasicApiCallbackWithResult;
import com.playbasis.sdk.subscriber.BaseApiSubscriber;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Tar on 8/19/16 AD.
 */
public class GameAPI {

  @Inject
  GetGameSettingInteractor getGameSettingInteractor;

  private static GameAPI gameAPI;

  public static GameAPI instance() {
    if (gameAPI == null) {
      gameAPI = new GameAPI();

      DaggerGameAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .gameModule(new GameModule())
          .build()
          .inject(gameAPI);
    }

    return gameAPI;
  }

  public static void retrieveGameSettingsForm(GameAPI.RetrieveGameSettingsForm form, GameAPI.RetrieveGameSettingsCallback callback) {
    instance().getGameSettingInteractor.setGameSettingsForm(form);
    instance().getGameSettingInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static class RetrieveGameSettingsForm extends com.playbasis.pbcore.rest.form.game.RetrieveGameSettingsForm {

  }

  public interface RetrieveGameSettingsCallback extends BasicApiCallbackWithResult<List<GameSetting>> {

  }
}
