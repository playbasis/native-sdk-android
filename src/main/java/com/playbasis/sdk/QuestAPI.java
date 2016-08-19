package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerQuestAPIComponent;
import com.playbasis.pbcore.dependency.module.QuestModule;
import com.playbasis.pbcore.domain.interactor.quest.CancelQuestInteractor;
import com.playbasis.pbcore.domain.interactor.quest.GetMissionInfoInteractor;
import com.playbasis.pbcore.domain.interactor.quest.GetQuestInfoInteractor;
import com.playbasis.pbcore.domain.interactor.quest.GetQuestLeaderboardInteractor;
import com.playbasis.pbcore.domain.interactor.quest.GetQuestListInteractor;
import com.playbasis.pbcore.domain.interactor.quest.JoinQuestInteractor;

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
}
