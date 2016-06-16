package com.playbasis.pbcore.domain.model;

import android.os.Parcelable;

import com.playbasis.pbcore.rest.result.response.ContentResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tar on 5/5/16 AD.
 */
public abstract class Content implements Parcelable {

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

  public void init(ContentResponse contentResponse) {
    this.id = contentResponse.id;
    this.title = contentResponse.title;
    this.summary = contentResponse.summary;
    this.detail = contentResponse.detail;
    this.category = contentResponse.category;
    this.image = contentResponse.image;
    this.startDate = contentResponse.startDate;
    this.endDate = contentResponse.endDate;
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
