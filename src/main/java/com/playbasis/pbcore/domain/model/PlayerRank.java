package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.response.PlayerRankResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tar on 6/20/16 AD.
 */
public class PlayerRank extends PBModel {

  protected String playerId;
  protected int value;

  public PlayerRank() {

  }

  public PlayerRank(PlayerRankResponse response) {
    update(response);
  }

  public static ArrayList<PlayerRank> createPlayerRanks(List<PlayerRankResponse> responses) {
    ArrayList<PlayerRank> playerRanks = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return playerRanks;
    }

    for (PlayerRankResponse playerRankResponse : responses) {
      playerRanks.add(new PlayerRank(playerRankResponse));
    }

    return playerRanks;
  }

  public void update(PlayerRankResponse response) {
    this.playerId = valueOrDefault(response.playerId, playerId);
    this.value = response.value;
  }

  public String getPlayerId() {
    return playerId;
  }

  public int getValue() {
    return value;
  }
}
