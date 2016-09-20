package com.playbasis.pbcore.rest.response;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Tar on 5/5/16 AD.
 */
public class ContentResponse {

  // TODO, make this class an inner class of ContentApiResult
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

    // TODO, serialize key-value into hashmap
    @SerializedName("follow_up_question_count")
    private int numberOfFollowUpQuestions;

  }

}
