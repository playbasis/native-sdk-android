package com.playbasis.pbcore.domain.model;

import android.os.Parcelable;

import com.playbasis.pbcore.rest.response.ContentResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tar on 5/5/16 AD.
 */
public abstract class Content extends PBModel implements Parcelable {

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

  public static <T extends Content> List<T> createFromContentResponses(Class<T> klass, List<ContentResponse> contentResponses) {
    ArrayList<T> results = new ArrayList<>();

    try {
      for (ContentResponse contentResponse : contentResponses) {
        T t = klass.newInstance();
        t.init(contentResponse);
        results.add(t);
      }
    } catch (Exception e) {

    }

    return results;
  }

  public void init(ContentResponse response) {
    init(response, true);
  }

  public void init(ContentResponse response, boolean allowNull) {
    if (response == null) {
      return;
    }

    this.id = valueOrDefault(response.id, this.id);
    this.title = valueOrDefault(response.title, this.title, allowNull);
    this.summary = valueOrDefault(response.summary, this.summary, allowNull);
    this.detail = valueOrDefault(response.detail, this.detail, allowNull);
    this.category = valueOrDefault(response.category, this.category, allowNull);
    this.image = valueOrDefault(response.image, this.image, allowNull);
    this.startDate = valueOrDefault(response.startDate, this.startDate, allowNull);
    this.endDate = valueOrDefault(response.endDate, this.endDate, allowNull);

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
