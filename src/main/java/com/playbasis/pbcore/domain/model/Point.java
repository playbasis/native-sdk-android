package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.response.PointResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tar on 6/20/16 AD.
 */
public class Point extends PBModel {

  protected String id;
  protected String name;
  protected int value;


  public Point() {

  }

  public Point(PointResponse response) {
    update(response);
  }

  public static ArrayList<Point> createPoints(List<PointResponse> responses) {
    ArrayList<Point> points = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return points;
    }

    for (PointResponse pointResponse : responses) {
      points.add(new Point(pointResponse));
    }

    return points;
  }

  public void update(PointResponse response) {
    this.id = valueOrDefault(response.id, id);
    this.name = response.name;
    this.value = response.value;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getValue() {
    return value;
  }
}
