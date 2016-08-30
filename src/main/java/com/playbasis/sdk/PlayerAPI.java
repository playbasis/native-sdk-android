package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerPlayerAPIComponent;
import com.playbasis.pbcore.dependency.module.PlayerModule;
import com.playbasis.pbcore.domain.interactor.player.ForgetPasswordInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerAllBadgesInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerAllGoodsInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerAllPointsInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerCustomFieldsInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerEarnedBadgesInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerJoinedQuestInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerPointInfoInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerPrivateInfoInteractor;
import com.playbasis.pbcore.domain.interactor.player.GetPlayerRankingInteractor;
import com.playbasis.pbcore.domain.interactor.player.PlayerAuthenticationInteractor;
import com.playbasis.pbcore.domain.interactor.player.RegisterPlayerInteractor;
import com.playbasis.pbcore.domain.interactor.player.RequestOTPCodeInteractor;
import com.playbasis.pbcore.domain.interactor.player.SendPlayerEmailVerificationInteractor;
import com.playbasis.pbcore.domain.interactor.player.SetPlayerCustomFieldsInteractor;
import com.playbasis.pbcore.domain.interactor.player.UpdatePlayerInteractor;
import com.playbasis.pbcore.domain.interactor.player.UpdatePlayerOrganizableModelInteractor;
import com.playbasis.pbcore.domain.interactor.player.VerifyOTPCodeInteractor;
import com.playbasis.pbcore.domain.model.Badge;
import com.playbasis.pbcore.domain.model.Goods;
import com.playbasis.pbcore.domain.model.Player;
import com.playbasis.pbcore.domain.model.PlayerRank;
import com.playbasis.pbcore.domain.model.Point;
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
import com.playbasis.pbcore.rest.result.player.GetUserCustomFieldsApiResult;
import com.playbasis.pbcore.rest.result.player.LoginPlayerApiResult;
import com.playbasis.sdk.callback.BaseApiCallback;
import com.playbasis.sdk.callback.BasicApiCallback;
import com.playbasis.sdk.callback.BasicApiCallbackWithResult;
import com.playbasis.sdk.subscriber.BaseApiSubscriber;

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
  @Inject
  protected RequestOTPCodeInteractor requestOTPCodeInteractor;
  @Inject
  protected VerifyOTPCodeInteractor verifyOTPCodeInteractor;

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
    instance().forgetPasswordInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static void badge(BadgeForm form, BadgeCallback callback) {
    instance().getPlayerEarnedBadgesInteractor.setGetPlayerBadgesForm(form);
    instance().getPlayerEarnedBadgesInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static void goods(GoodsForm form, GoodsCallback callback) {
    instance().getPlayerAllGoodsInteractor.setGetPlayerGoodsForm(form);
    instance().getPlayerAllGoodsInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static void points(PointsForm form, PointsCallback callback) {
    instance().getPlayerAllPointsInteractor.setGetPlayerPointsForm(form);
    instance().getPlayerAllPointsInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static void listCustomFieldsOfPlayer(ListCustomFieldsOfPlayerForm form, final ListCustomFieldsOfPlayerCallback callback) {
    instance().getPlayerCustomFieldsInteractor.setGetPlayerCustomFieldForm(form);
    instance().getPlayerCustomFieldsInteractor.execute(new BaseApiSubscriber<GetUserCustomFieldsApiResult>(callback) {
      @Override
      public void onCompleted() {
        if (callback != null) {
          callback.onSuccess(resultObj.getCustomFieldMap());
        }
      }
    });
  }

  public static void allBadges(AllBadgesForm form, AllBadgesCallback callback) {
    instance().getPlayerAllBadgesInteractor.setGetPlayerBadgesForm(form);
    instance().getPlayerAllBadgesInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static void detailedPlayerInfoPrivate(DetailedPlayerInfoPrivateForm form, DetailedPlayerInfoPrivateCallback callback) {
    instance().getPlayerPrivateInfoInteractor.setGetPlayerForm(form);
    instance().getPlayerPrivateInfoInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static void questOfPlayer(QuestOfPlayerForm form, QuestOfPlayerCallback callback) {
    instance().getPlayerJoinedQuestInteractor.setGetPlayerJoinedQuestListForm(form);
    instance().getPlayerJoinedQuestInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static void point(PointForm form, PointCallback callback) {
    instance().getPlayerPointInfoInteractor.setGetPlayerPointInfoForm(form);
    instance().getPlayerPointInfoInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static void ranks(RanksForm form, RanksCallback callback) {
    instance().getPlayerRankingInteractor.setGetPlayerRankingForm(form);
    instance().getPlayerRankingInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static void playerAuth(PlayerAuthForm form, final PlayerAuthCallback callback) {
    instance().playerAuthenticationInteractor.setPlayerAuthenticationForm(form);
    instance().playerAuthenticationInteractor.execute(new BaseApiSubscriber<LoginPlayerApiResult>(callback) {
      @Override
      public void onCompleted() {
        if (callback != null) {
          callback.onSuccess(resultObj.getUserId());
        }
      }
    });
  }

  public static void register(RegisterForm form, RegisterCallback callback) {
    instance().registerPlayerInteractor.setPlayerRegistrationForm(form);
    instance().registerPlayerInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static void verifyPlayerEmail(VerifyPlayerEmailForm form, VerifyPlayerEmailCallback callback) {
    instance().sendPlayerEmailVerificationInteractor.setPlayerEmailVerificationForm(form);
    instance().sendPlayerEmailVerificationInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static void setCustomFieldOfPlayer(SetCustomFieldOfPlayerForm form, SetCustomFieldOfPlayerCallback callback) {
    instance().setPlayerCustomFieldsInteractor.setCurtomFieldForm(form);
    instance().setPlayerCustomFieldsInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static void update(UpdateForm form, UpdateCallback callback) {
    instance().updatePlayerInteractor.setUpdateUserForm(form);
    instance().updatePlayerInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static void requestOTPCode(RequestOTPCodeForm form, RequestOTPCodeCallback callback) {
    instance().requestOTPCodeInteractor.setRequestOTPCodeForm(form);
    instance().requestOTPCodeInteractor.execute(new BaseApiSubscriber<>(callback));
  }

  public static void verifyOTPCode(VerifyOTPCodeForm form, VerifyOTPCodeCallback callback) {
    instance().verifyOTPCodeInteractor.setVerifyOTPCodeForm(form);
    instance().verifyOTPCodeInteractor.execute(new BaseApiSubscriber<>(callback));
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

  public static class DetailedPlayerInfoPrivateForm extends GetPlayerForm {

    public DetailedPlayerInfoPrivateForm(String playerId) {
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

  public static class RequestOTPCodeForm extends com.playbasis.pbcore.rest.form.player.RequestOTPCodeForm {

    public RequestOTPCodeForm(String playerId) {
      super(playerId);
    }
  }

  public static class VerifyOTPCodeForm extends com.playbasis.pbcore.rest.form.player.VerifyOTPCodeForm {

    public VerifyOTPCodeForm(String playerId, String code) {
      super(playerId, code);
    }
  }

  public interface ResetPlayerPasswordCallback extends BasicApiCallback {

  }

  public interface BadgeCallback extends BasicApiCallbackWithResult<List<Badge>> {

  }

  public interface GoodsCallback extends BasicApiCallbackWithResult<List<Goods>> {

  }

  public interface PointsCallback extends BasicApiCallbackWithResult<List<Point>> {

  }

  public interface ListCustomFieldsOfPlayerCallback extends BaseApiCallback {
    void onSuccess(HashMap<String, String> customFields);
  }

  public interface AllBadgesCallback extends BasicApiCallbackWithResult<List<Badge>> {

  }

  public interface DetailedPlayerInfoPrivateCallback extends BasicApiCallbackWithResult<Player> {

  }

  public interface QuestOfPlayerCallback extends BasicApiCallbackWithResult<List<Point>> {

  }

  public interface PointCallback extends BasicApiCallbackWithResult<Point> {

  }

  public interface RanksCallback extends BasicApiCallbackWithResult<List<PlayerRank>> {

  }

  public interface PlayerAuthCallback extends BaseApiCallback {
    void onSuccess(String playerId);
  }

  public interface RegisterCallback extends BasicApiCallback {

  }

  public interface VerifyPlayerEmailCallback extends BasicApiCallback {

  }

  public interface SetCustomFieldOfPlayerCallback extends BasicApiCallback {

  }

  public interface UpdateCallback extends BasicApiCallback {

  }

  public interface RequestOTPCodeCallback extends BasicApiCallback {

  }

  public interface VerifyOTPCodeCallback extends BasicApiCallback {

  }
}
