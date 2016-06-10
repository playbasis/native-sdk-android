package com.playbasis.pbcore.domain.model;

import android.os.Parcelable;
import android.text.Html;

import com.playbasis.pbcore.rest.result.response.ContentResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tar on 5/5/16 AD.
 */
public abstract class Content implements Parcelable {

  public String id;
  public String title;
  public String summary;
  public String detail;
  public String category;
  public String image;
  public Date startDate;
  public Date endDate;

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

  public String getImageUrl() {
    if (image.startsWith("data/")) {
      return "http://images.pbapp.net/" + image;
    }

    return image;
  }

  public String getTitle() {
    return Html.fromHtml(title).toString();
  }

  public String getSummary() {
    return Html.fromHtml(summary).toString();
  }

  public String getDetail() {
    return Html.fromHtml(detail).toString();
  }
}
