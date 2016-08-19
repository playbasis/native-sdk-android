package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerPlayerAPIComponent;
import com.playbasis.pbcore.dependency.module.PlayerModule;
import com.playbasis.pbcore.domain.interactor.player.ForgetPasswordInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerAllBadgesInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerAllGoodsInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerAllPointsInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerCustomFieldsInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerEarnedBadgesInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerPrivateInfoInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerJoinedQuestInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerPointInfoInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerRankingInteractor;
import com.playbasis.pbcore.domain.interactor.player.PlayerAuthenticationInteractor;
import com.playbasis.pbcore.domain.interactor.player.RegisterPlayerInteractor;
import com.playbasis.pbcore.domain.interactor.player.SendPlayerEmailVerificationInteractor;
import com.playbasis.pbcore.domain.interactor.player.SetPlayerCustomFieldsInteractor;
import com.playbasis.pbcore.domain.interactor.player.UpdatePlayerInteractor;
import com.playbasis.pbcore.domain.interactor.player.UpdatePlayerOrganizableModelInteractor;

import javax.inject.Inject;

/**
 * Created by Tar on 8/19/16 AD.
 */
public class PlayerAPI {

  private static PlayerAPI playerAPI;

  @Inject
  protected ForgetPasswordInteractor forgetPasswordInteractor;
  @Inject
  protected GetPlayerAllBadgesInteractor getPlayerAllBadgesInteractor;
  @Inject
  protected GetPlayerAllGoodsInteractor getPlayerAllGoodsInteractor;
  @Inject
  protected GetPlayerAllPointsInteractor getPlayerAllPointsInteractor;
  @Inject
  protected GetPlayerCustomFieldsInteractor getPlayerCustomFieldsInteractor;
  @Inject
  protected GetPlayerEarnedBadgesInteractor getPlayerEarnedBadgesInteractor;
  @Inject
  protected GetPlayerPrivateInfoInteractor getPlayerPrivateInfoInteractor;
  @Inject
  protected GetPlayerJoinedQuestInteractor getPlayerJoinedQuestInteractor;
  @Inject
  protected GetPlayerPointInfoInteractor getPlayerPointInfoInteractor;
  @Inject
  protected GetPlayerRankingInteractor getPlayerRankingInteractor;
  @Inject
  protected PlayerAuthenticationInteractor playerAuthenticationInteractor;
  @Inject
  protected RegisterPlayerInteractor registerPlayerInteractor;
  @Inject
  protected SendPlayerEmailVerificationInteractor sendPlayerEmailVerificationInteractor;
  @Inject
  protected SetPlayerCustomFieldsInteractor setPlayerCustomFieldsInteractor;
  @Inject
  protected UpdatePlayerInteractor updatePlayerInteractor;
  @Inject
  protected UpdatePlayerOrganizableModelInteractor updatePlayerOrganizableModelInteractor;

  public static PlayerAPI instance() {
    if (playerAPI == null) {
      playerAPI = new PlayerAPI();

      DaggerPlayerAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .playerModule(new PlayerModule())
          .build()
          .inject(playerAPI);
    }

    return playerAPI;
  }
}
