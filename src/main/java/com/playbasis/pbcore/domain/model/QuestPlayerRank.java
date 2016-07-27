package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.response.QuestPlayerRankResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class QuestPlayerRank extends PBModel {

  private String status;
  private Date completedDate;
  private Date joinedDate;
  private int goal;
  private int current;
  private Player player;
  protected int rank;

  public QuestPlayerRank() {

  }

  public QuestPlayerRank(QuestPlayerRankResponse response) {
    update(response);
  }

  public static ArrayList<QuestPlayerRank> createQuestPlayerRank(List<QuestPlayerRankResponse> responses) {
    ArrayList<QuestPlayerRank> questPlayerRanks = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return questPlayerRanks;
    }

    for (QuestPlayerRankResponse response : responses) {
      questPlayerRanks.add(new QuestPlayerRank(response));
    }

    return questPlayerRanks;
  }

  public void update(QuestPlayerRankResponse response) {
    if (response == null) {
      return;
    }

    this.status = response.status;
    this.completedDate = response.completedDate;
    this.joinedDate = response.joinedDate;
    this.goal = response.goal;
    this.current = response.current;
    this.rank = response.rank;

    if (response.playerResponse != null) {
      if (this.player == null) {
        this.player = new Player(response.playerResponse.playerId);
      }

      player.update(response.playerResponse);
    }
  }

  public String getStatus() {
    return status;
  }

  public Date getCompletedDate() {
    return completedDate;
  }

  public Date getJoinedDate() {
    return joinedDate;
  }

  public int getGoal() {
    return goal;
  }

  public int getCurrent() {
    return current;
  }

  public Player getPlayer() {
    return player;
  }

  public int getRank() {
    return rank;
  }
}
