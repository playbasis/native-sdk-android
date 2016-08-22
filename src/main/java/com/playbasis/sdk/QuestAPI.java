package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerQuestAPIComponent;
import com.playbasis.pbcore.dependency.module.QuestModule;
import com.playbasis.pbcore.domain.interactor.quest.CancelQuestInteractor;
import com.playbasis.pbcore.domain.interactor.quest.GetMissionInfoInteractor;
import com.playbasis.pbcore.domain.interactor.quest.GetQuestInfoInteractor;
import com.playbasis.pbcore.domain.interactor.quest.GetQuestLeaderboardInteractor;
import com.playbasis.pbcore.domain.interactor.quest.GetQuestListInteractor;
import com.playbasis.pbcore.domain.interactor.quest.JoinQuestInteractor;
import com.playbasis.pbcore.domain.model.Mission;
import com.playbasis.pbcore.domain.model.Quest;
import com.playbasis.pbcore.domain.model.QuestPlayerRank;
import com.playbasis.pbcore.rest.form.quest.GetMissionInfoForm;
import com.playbasis.pbcore.rest.form.quest.GetQuestInfoForm;
import com.playbasis.pbcore.rest.form.quest.GetQuestListForm;
import com.playbasis.pbcore.rest.form.quest.QuestLeaderboardForm;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Tar on 8/19/16 AD.
 */
public class QuestAPI {

  private static QuestAPI questAPI;

  @Inject
  protected GetQuestInfoInteractor getQuestInfoInteractor;
  @Inject
  protected GetQuestListInteractor getQuestListInteractor;
  @Inject
  protected GetQuestLeaderboardInteractor getQuestLeaderboardInteractor;
  @Inject
  protected JoinQuestInteractor joinQuestInteractor;
  @Inject
  protected CancelQuestInteractor cancelQuestInteractor;
  @Inject
  protected GetMissionInfoInteractor getMissionInfoInteractor;

  public static QuestAPI instance() {
    if (questAPI == null) {
      questAPI = new QuestAPI();

      DaggerQuestAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .questModule(new QuestModule())
          .build()
          .inject(questAPI);
    }

    return questAPI;
  }

  public static void questListInfo(QuestListInfoForm form, QuestListInfoCallback callback) {
    instance().getQuestListInteractor.setGetQuestListForm(form);
    instance().getQuestListInteractor.execute(new APIDefaultSubscriber<>(callback));
  }

  public static void questInfo(QuestInfoForm form, QuestInfoCallback callback) {
    instance().getQuestInfoInteractor.setGetQuestListForm(form);
    instance().getQuestInfoInteractor.execute(new APIDefaultSubscriber<>(callback));
  }

  public static void questLeaderBoard(QuestLeaderBoardForm form, QuestLeaderBoardCallback callback) {
    instance().getQuestLeaderboardInteractor.setQuestLeaderboardForm(form);
    instance().getQuestLeaderboardInteractor.execute(new APIDefaultSubscriber<>(callback));
  }

  public static void joinQuest(JoinQuestForm form, JoinQuestCallback callback) {
    instance().joinQuestInteractor.setJoinQuestForm(form);
    instance().joinQuestInteractor.execute(new APIDefaultSubscriber<>(callback));
  }

  public static void cancelQuest(CancelQuestForm form, CancelQuestCallback callback) {
    instance().cancelQuestInteractor.setCancelQuestForm(form);
    instance().cancelQuestInteractor.execute(new APIDefaultSubscriber<>(callback));
  }

  public static void missionInfo(MissionInfoForm form, MissionInfoCallback callback) {
    instance().getMissionInfoInteractor.setGetQuestListForm(form);
    instance().getMissionInfoInteractor.execute(new APIDefaultSubscriber<>(callback));
  }

  public static class QuestListInfoForm extends GetQuestListForm {

  }

  public static class QuestInfoForm extends GetQuestInfoForm {

    public QuestInfoForm(String questId) {
      super(questId);
    }
  }

  public static class QuestLeaderBoardForm extends QuestLeaderboardForm {

    public QuestLeaderBoardForm(String questId) {
      super(questId);
    }
  }

  public static class JoinQuestForm extends com.playbasis.pbcore.rest.form.quest.JoinQuestForm {

    public JoinQuestForm(String questId, String playerId) {
      super(questId, playerId);
    }
  }

  public static class CancelQuestForm extends com.playbasis.pbcore.rest.form.quest.CancelQuestForm {

    public CancelQuestForm(String questId, String playerId) {
      super(questId, playerId);
    }
  }

  public static class MissionInfoForm extends GetMissionInfoForm {

    public MissionInfoForm(String questId, String missionId) {
      super(questId, missionId);
    }
  }

  public interface QuestListInfoCallback extends BaseApiCallback<List<Quest>> {

  }

  public interface QuestInfoCallback extends BaseApiCallback<Quest> {

  }

  public interface QuestLeaderBoardCallback extends BaseApiCallback<List<QuestPlayerRank>> {

  }

  public interface JoinQuestCallback extends BaseApiCallback<Boolean> {

  }

  public interface CancelQuestCallback extends BaseApiCallback<Boolean> {

  }

  public interface MissionInfoCallback extends BaseApiCallback<Mission> {

  }
}
