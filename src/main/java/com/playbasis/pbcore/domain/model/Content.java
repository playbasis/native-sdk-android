package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.response.ContentResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tar on 5/5/16 AD.
 */
public class Content extends PBModel {

  protected String id;
  protected String title;
  protected String summary;
  protected String detail;
  protected String category;
  protected String image;
  protected Date startDate;
  protected Date endDate;

  public Content() {

  }

  public Content(ContentResponse response) {
    update(response);
  }

  public static List<Content> createContents(List<ContentResponse> contentResponses) {
    ArrayList<Content> contents = new ArrayList<>();

    try {
      for (ContentResponse contentResponse : contentResponses) {
        contents.add(new Content(contentResponse));
      }
    } catch (Exception e) {

    }

    return contents;
  }

  public void update(ContentResponse response) {
    if (response == null) {
      return;
    }

    this.id = valueOrDefault(response.id, id);
    this.title = response.title;
    this.summary = response.summary;
    this.detail = response.detail;
    this.category = response.category;
    this.image = response.image;
    this.startDate = response.startDate;
    this.endDate = response.endDate;
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getImageUrl() {
    if (image.startsWith("data/")) {
      return "http://images.pbapp.net/" + image;
    }

    return image;
  }

  public void setImageUrl(String image) {
    this.image = image;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
}
