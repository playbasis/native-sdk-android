package com.playbasis.pbcore.domain.model;

import android.os.Parcel;

import com.playbasis.pbcore.rest.response.PlayerResponse;
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
    this.player = createPlayer(response.playerResponse);
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

  protected Player createPlayer(PlayerResponse playerResponse) {
    if (playerResponse != null && playerResponse.playerId != null) {
      return new Player(playerResponse);
    }

    return null;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.status);
    dest.writeLong(this.completedDate != null ? this.completedDate.getTime() : -1);
    dest.writeLong(this.joinedDate != null ? this.joinedDate.getTime() : -1);
    dest.writeInt(this.goal);
    dest.writeInt(this.current);
    dest.writeParcelable(this.player, flags);
    dest.writeInt(this.rank);
  }

  protected QuestPlayerRank(Parcel in) {
    this.status = in.readString();
    long tmpCompletedDate = in.readLong();
    this.completedDate = tmpCompletedDate == -1 ? null : new Date(tmpCompletedDate);
    long tmpJoinedDate = in.readLong();
    this.joinedDate = tmpJoinedDate == -1 ? null : new Date(tmpJoinedDate);
    this.goal = in.readInt();
    this.current = in.readInt();
    this.player = in.readParcelable(Player.class.getClassLoader());
    this.rank = in.readInt();
  }

  public static final Creator<QuestPlayerRank> CREATOR = new Creator<QuestPlayerRank>() {
    @Override
    public QuestPlayerRank createFromParcel(Parcel source) {
      return new QuestPlayerRank(source);
    }

    @Override
    public QuestPlayerRank[] newArray(int size) {
      return new QuestPlayerRank[size];
    }
  };
}
