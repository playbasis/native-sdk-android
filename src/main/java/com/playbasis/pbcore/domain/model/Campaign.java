package com.playbasis.pbcore.domain.model;

import android.os.Parcel;

import com.playbasis.pbcore.rest.response.ActiveCampaignResponse;
import com.playbasis.pbcore.rest.response.GameStageResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Nott on 18/11/2559.
 * playbasis-sdk-android-project
 */

public class Campaign extends PBModel {
  public static final String TAG = "Campaign";

  public String name;
  public String imageUrl;
  public int weight;
  public Date startDate;
  public Date endDate;

  public Campaign() {
  }

  public Campaign(ActiveCampaignResponse response) {
    update(response);
  }

  public void update(ActiveCampaignResponse response) {
    if (response == null) {
      return;
    }

    this.name = response.name;
    this.imageUrl = response.imageUrl;
    this.weight = response.weight;
    this.imageUrl = response.imageUrl;
    this.startDate = response.startDate;
    this.endDate = response.endDate;
  }

  public static <T extends ActiveCampaignResponse> ArrayList<Campaign> createCampaigns(List<T> responses) {
    ArrayList<Campaign> campaigns = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return campaigns;
    }

    for (T response : responses) {
      campaigns.add(new Campaign(response));
    }

    return campaigns;
  }

  public String getName() {
    return name;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public int getWeight() {
    return weight;
  }

  public Date getStartDate() {
    return startDate;
  }

  public Date getEndDate() {
    return endDate;
  }


  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.name);
    dest.writeString(this.imageUrl);
    dest.writeInt(this.weight);
    dest.writeLong(this.startDate != null ? this.startDate.getTime() : -1);
    dest.writeLong(this.endDate != null ? this.endDate.getTime() : -1);
  }

  protected Campaign(Parcel in) {
    this.name = in.readString();
    this.imageUrl = in.readString();
    this.weight = in.readInt();
    long tmpStartDate = in.readLong();
    this.startDate = tmpStartDate == -1 ? null : new Date(tmpStartDate);
    long tmpEndDate = in.readLong();
    this.endDate = tmpEndDate == -1 ? null : new Date(tmpEndDate);
  }

  public static final Creator<Campaign> CREATOR = new Creator<Campaign>() {
    @Override
    public Campaign createFromParcel(Parcel source) {
      return new Campaign(source);
    }

    @Override
    public Campaign[] newArray(int size) {
      return new Campaign[size];
    }
  };
}
