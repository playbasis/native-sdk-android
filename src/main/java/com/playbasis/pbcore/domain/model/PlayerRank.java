package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.response.PlayerRankResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tar on 6/20/16 AD.
 */
public class PlayerRank extends PBModel {

  protected String sortBy;
  protected int value;
  private Player player;

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
    this.sortBy = response.sortBy;
    this.value = response.value;

    if (response.playerResponse != null) {
      this.player = new Player(response.playerResponse);
    }
  }

  public Player getPlayer() {
    return player;
  }

  public String getSortBy() {
    return sortBy;
  }

  public int getValue() {
    return value;
  }
}
