package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.response.PlayerMissionResponse;

/**
 * Created by Tar on 6/30/16 AD.
 */
public class Incompletion extends PBModel {

  protected String incompletionId;
  protected String type;
  protected String value;
  protected String elementId;
  protected String filter;

  public Incompletion(PlayerMissionResponse.PendingResponse.IncompletionResponse incompletionResponse) {
    if (incompletionResponse == null) {
      return;
    }

    this.incompletionId = incompletionResponse.incompletionId;
    this.type = incompletionResponse.type;
    this.value = incompletionResponse.value;
    this.elementId = incompletionResponse.elementId;
    this.filter = incompletionResponse.filter;
  }

  public String getIncompletionId() {
    return incompletionId;
  }

  public String getType() {
    return type;
  }

  public String getValue() {
    return value;
  }

  public String getElementId() {
    return elementId;
  }

  public String getFilter() {
    return filter;
  }
}