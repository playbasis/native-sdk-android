package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.response.QuestPlayerRankResponse;

import java.util.Date;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class QuestPlayerRank extends PBModel {

  public String status;
  public Date completedDate;
  public int goal;
  public int current;
  public Player player;

  public void init(QuestPlayerRankResponse response) {
    init(response, true);
  }

  public void init(QuestPlayerRankResponse response, boolean allowNull) {
    if (response == null) {
      return;
    }

    this.status = valueOrDefault(response.status, this.status, allowNull);
    this.completedDate = valueOrDefault(response.completedDate, this.completedDate, allowNull);
    this.goal = valueOrDefault(response.goal, this.goal, allowNull);
    this.current = valueOrDefault(response.current, this.current, allowNull);

    if (response.playerResponse != null) {
      if (this.player == null) {
        this.player = new Player(response.playerResponse.playerId);
      }

      player.init(response.playerResponse, false);
    }
  }

  public String getStatus() {
    return status;
  }

  public Date getCompletedDate() {
    return completedDate;
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
}
