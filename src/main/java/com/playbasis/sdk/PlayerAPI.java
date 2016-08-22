package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerPlayerAPIComponent;
import com.playbasis.pbcore.dependency.module.PlayerModule;
import com.playbasis.pbcore.domain.interactor.player.ForgetPasswordInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerAllBadgesInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerAllGoodsInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerAllPointsInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerCustomFieldsInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerEarnedBadgesInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerJoinedQuestInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerPointInfoInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerRankingInteractor;
import com.playbasis.pbcore.domain.interactor.player.PlayerAuthenticationInteractor;
import com.playbasis.pbcore.domain.interactor.player.RegisterPlayerInteractor;
import com.playbasis.pbcore.domain.interactor.player.SendPlayerEmailVerificationInteractor;
import com.playbasis.pbcore.domain.interactor.player.SetPlayerCustomFieldsInteractor;
import com.playbasis.pbcore.domain.interactor.player.UpdatePlayerInteractor;
import com.playbasis.pbcore.domain.interactor.player.UpdatePlayerOrganizableModelInteractor;
import com.playbasis.pbcore.domain.model.Badge;
import com.playbasis.pbcore.domain.model.Goods;
import com.playbasis.pbcore.domain.model.Player;
import com.playbasis.pbcore.domain.model.PlayerRank;
import com.playbasis.pbcore.domain.model.Point;
import com.playbasis.pbcore.domain.model.Quest;
import com.playbasis.pbcore.rest.form.player.ForgetPlayerPasswordForm;
import com.playbasis.pbcore.rest.form.player.GetPlayerBadgesForm;
import com.playbasis.pbcore.rest.form.player.GetPlayerCustomFieldForm;
import com.playbasis.pbcore.rest.form.player.GetPlayerForm;
import com.playbasis.pbcore.rest.form.player.GetPlayerGoodsForm;
import com.playbasis.pbcore.rest.form.player.GetPlayerJoinedQuestListForm;
import com.playbasis.pbcore.rest.form.player.GetPlayerPointInfoForm;
import com.playbasis.pbcore.rest.form.player.GetPlayerPointsForm;
import com.playbasis.pbcore.rest.form.player.GetPlayerRankingForm;
import com.playbasis.pbcore.rest.form.player.PlayerAuthenticationForm;
import com.playbasis.pbcore.rest.form.player.PlayerEmailVerificationForm;
import com.playbasis.pbcore.rest.form.player.PlayerRegistrationForm;
import com.playbasis.pbcore.rest.form.player.UpdatePlayerCustomFieldForm;
import com.playbasis.pbcore.rest.form.player.UpdatePlayerForm;

import java.util.HashMap;
import java.util.List;

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
  protected GetPlayerInteractor getPlayerInteractor;
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

  public static void resetPlayerPassword(ResetPlayerPasswordForm form, ResetPlayerPasswordCallback callback) {
    instance().forgetPasswordInteractor.setForgetPlayerPasswordForm(form);
    instance().forgetPasswordInteractor.execute(new APIDefaultSubscriber<>(callback));
  }

  public static void badge(BadgeForm form, BadgeCallback callback) {
    instance().getPlayerEarnedBadgesInteractor.setGetPlayerBadgesForm(form);
    instance().getPlayerEarnedBadgesInteractor.execute(new APIDefaultSubscriber<>(callback));
  }

  public static void goods(GoodsForm form, GoodsCallback callback) {
    instance().getPlayerAllGoodsInteractor.setGetPlayerGoodsForm(form);
    instance().getPlayerAllGoodsInteractor.execute(new APIDefaultSubscriber<>(callback));
  }

  public static void points(PointsForm form, PointsCallback callback) {
    instance().getPlayerAllPointsInteractor.setGetPlayerPointsForm(form);
    instance().getPlayerAllPointsInteractor.execute(new APIDefaultSubscriber<>(callback));
  }

  public static void listCustomFieldsOfPlayer(ListCustomFieldsOfPlayerForm form, ListCustomFieldsOfPlayerCallback callback) {
    instance().getPlayerCustomFieldsInteractor.setGetPlayerCustomFieldForm(form);
    instance().getPlayerCustomFieldsInteractor.execute(new APIDefaultSubscriber<>(callback));
  }

  public static void allBadges(AllBadgesForm form, AllBadgesCallback callback) {
    instance().getPlayerAllBadgesInteractor.setGetPlayerBadgesForm(form);
    instance().getPlayerAllBadgesInteractor.execute(new APIDefaultSubscriber<>(callback));
  }

  public static void detailedPlayerInfoPri(DetailedPlayerInfoPrivate form, DetailedPlayerInfoPriCallback callback) {
    instance().getPlayerInteractor.setGetPlayerForm(form);
    instance().getPlayerInteractor.execute(new APIDefaultSubscriber<>(callback));
  }

  public static void questOfPlayer(QuestOfPlayerForm form, QuestOfPlayerCallback callback) {
    instance().getPlayerJoinedQuestInteractor.setGetPlayerJoinedQuestListForm(form);
    instance().getPlayerJoinedQuestInteractor.execute(new APIDefaultSubscriber<>(callback));
  }

  public static void point(PointForm form, PointCallback callback) {
    instance().getPlayerPointInfoInteractor.setGetPlayerPointInfoForm(form);
    instance().getPlayerPointInfoInteractor.execute(new APIDefaultSubscriber<>(callback));
  }

  public static void ranks(RanksForm form, RanksCallback callback) {
    instance().getPlayerRankingInteractor.setGetPlayerRankingForm(form);
    instance().getPlayerRankingInteractor.execute(new APIDefaultSubscriber<>(callback));
  }

  public static void playerAuth(PlayerAuthForm form, PlayerAuthCallback callback) {
    instance().playerAuthenticationInteractor.setPlayerAuthenticationForm(form);
    instance().playerAuthenticationInteractor.execute(new APIDefaultSubscriber<>(callback));
  }

  public static void register(RegisterForm form, RegisterCallback callback) {
    instance().registerPlayerInteractor.setPlayerRegistrationForm(form);
    instance().registerPlayerInteractor.execute(new APIDefaultSubscriber<>(callback));
  }

  public static void verifyPlayerEmail(VerifyPlayerEmailForm form, VerifyPlayerEmailCallback callback) {
    instance().sendPlayerEmailVerificationInteractor.setPlayerEmailVerificationForm(form);
    instance().sendPlayerEmailVerificationInteractor.execute(new APIDefaultSubscriber<>(callback));
  }

  public static void setCustomFieldOfPlayer(SetCustomFieldOfPlayerForm form, SetCustomFieldOfPlayerCallback callback) {
    instance().setPlayerCustomFieldsInteractor.setCurtomFieldForm(form);
    instance().setPlayerCustomFieldsInteractor.execute(new APIDefaultSubscriber<>(callback));
  }

  public static void update(UpdateForm form, UpdateCallback callback) {
    instance().updatePlayerInteractor.setUpdateUserForm(form);
    instance().updatePlayerInteractor.execute(new APIDefaultSubscriber<>(callback));
  }

  public static class ResetPlayerPasswordForm extends ForgetPlayerPasswordForm {

    public ResetPlayerPasswordForm(String email) {
      super(email);
    }
  }

  public static class BadgeForm extends GetPlayerBadgesForm {

    public BadgeForm(String playerId) {
      super(playerId);
    }
  }

  public static class GoodsForm extends GetPlayerGoodsForm {

    public GoodsForm(String playerId) {
      super(playerId);
    }
  }

  public static class PointsForm extends GetPlayerPointsForm {

    public PointsForm(String playerId) {
      super(playerId);
    }
  }

  public static class ListCustomFieldsOfPlayerForm extends GetPlayerCustomFieldForm {

    public ListCustomFieldsOfPlayerForm(String playerId) {
      super(playerId);
    }
  }

  public static class AllBadgesForm extends GetPlayerBadgesForm {

    public AllBadgesForm(String playerId) {
      super(playerId);
    }
  }

  public static class DetailedPlayerInfoPrivate extends GetPlayerForm {

    public DetailedPlayerInfoPrivate(String playerId) {
      super(playerId);
    }
  }

  public static class QuestOfPlayerForm extends GetPlayerJoinedQuestListForm {

    public QuestOfPlayerForm(String playerId) {
      super(playerId);
    }
  }

  public static class PointForm extends GetPlayerPointInfoForm {

    public PointForm(String playerId, String pointName) {
      super(playerId, pointName);
    }
  }

  public static class RanksForm extends GetPlayerRankingForm {

    public RanksForm(String rankBy, int limit) {
      super(rankBy, limit);
    }
  }

  public static class PlayerAuthForm extends PlayerAuthenticationForm {

    public PlayerAuthForm(String password) {
      this.password = password;
    }
  }

  public static class RegisterForm extends PlayerRegistrationForm {

    public RegisterForm(String playerId, String userName, String email) {
      super(playerId, userName, email);
    }
  }

  public static class VerifyPlayerEmailForm extends PlayerEmailVerificationForm {

    public VerifyPlayerEmailForm(String playerId) {
      super(playerId);
    }
  }

  public static class SetCustomFieldOfPlayerForm extends UpdatePlayerCustomFieldForm {

    public SetCustomFieldOfPlayerForm(String playerId, String keys, String values) {
      super(playerId);

      setCustomField(keys, values);
    }
  }

  public static class UpdateForm extends UpdatePlayerForm {

    public UpdateForm(String playerId) {
      super(playerId);
    }
  }

  public interface ResetPlayerPasswordCallback extends BaseApiCallback<Boolean> {

  }

  public interface BadgeCallback extends BaseApiCallback<List<Badge>> {

  }

  public interface GoodsCallback extends BaseApiCallback<List<Goods>> {

  }

  public interface PointsCallback extends BaseApiCallback<List<Point>> {

  }

  public interface ListCustomFieldsOfPlayerCallback extends BaseApiCallback<HashMap<String, String>> {

  }

  public interface AllBadgesCallback extends BaseApiCallback<List<Badge>> {

  }

  public interface DetailedPlayerInfoPriCallback extends BaseApiCallback<Player> {

  }

  public interface QuestOfPlayerCallback extends BaseApiCallback<List<Quest>> {

  }

  public interface PointCallback extends BaseApiCallback<Point> {

  }

  public interface RanksCallback extends BaseApiCallback<List<PlayerRank>> {

  }

  public interface PlayerAuthCallback extends BaseApiCallback<Boolean> {

  }

  public interface RegisterCallback extends BaseApiCallback<Boolean> {

  }

  public interface VerifyPlayerEmailCallback extends BaseApiCallback<Boolean> {

  }

  public interface SetCustomFieldOfPlayerCallback extends BaseApiCallback<Boolean> {

  }

  public interface UpdateCallback extends BaseApiCallback<Boolean> {

  }
}
