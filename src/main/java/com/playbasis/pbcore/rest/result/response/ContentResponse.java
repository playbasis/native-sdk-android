package com.playbasis.pbcore.rest.result.response;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Tar on 5/5/16 AD.
 */
public class ContentResponse {

  @SerializedName("node_id")
  public String id;
  @SerializedName("title")
  public String title;
  @SerializedName("summary")
  public String summary;
  @SerializedName("detail")
  public String detail;
  @SerializedName("category")
  public String category;
  @SerializedName("image")
  public String image;
  @SerializedName("date_start")
  public Date startDate;
  @SerializedName("date_end")
  public Date endDate;
  @SerializedName("pin")
  public String pin;
  @SerializedName("custom")
  private Custom custom;

  public int getNumberOfFollowUpQuestions() {
    if (custom != null) {
      return custom.numberOfFollowUpQuestions;
    }

    return 3;
  }

  private class Custom {

    @SerializedName("follow_up_question_count")
    private int numberOfFollowUpQuestions;

  }

}
