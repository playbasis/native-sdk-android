package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerGameAPIComponent;
import com.playbasis.pbcore.dependency.module.GameModule;
import com.playbasis.pbcore.domain.interactor.game.GetActiveCampaignInteractor;
import com.playbasis.pbcore.domain.interactor.game.GetGameSettingInteractor;
import com.playbasis.pbcore.domain.model.Campaign;
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
  @Inject
  GetActiveCampaignInteractor getActiveCampaignInteractor;

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

  public static void retrieveGameSettings(GameAPI.RetrieveGameSettingsForm form, GameAPI.RetrieveGameSettingsCallback callback) {
    instance().getGameSettingInteractor.setGameSettingsForm(form);
    instance().getGameSettingInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static class RetrieveGameSettingsForm extends com.playbasis.pbcore.rest.form.game.RetrieveGameSettingsForm {

  }

  public interface RetrieveGameSettingsCallback extends BasicApiCallbackWithResult<List<GameSetting>> {

  }

  public static void retrieveActiveCampaign(GameAPI.RetrieveActiveCampaignForm form, GameAPI.RetrieveActiveCampaignCallback callback) {
    instance().getActiveCampaignInteractor.setForm(form);
    instance().getActiveCampaignInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static class RetrieveActiveCampaignForm extends com.playbasis.pbcore.rest.form.game.RetrieveActiveCampaignForm {

  }

  public interface RetrieveActiveCampaignCallback extends BasicApiCallbackWithResult<Campaign> {

  }
}
