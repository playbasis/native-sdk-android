package com.playbasis.pbcore.rest.form.service;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 9/20/16 AD.
 */
public class RecentActivitiesForm extends PBForm {

  protected String playerId = null;
  protected int offset = 0;
  protected int limit = 20;
  protected String lastReadActivityId = null;
  protected String mode = "all";
  protected String eventType = null;

  public RecentActivitiesForm() {

  }

  public void setPlayerId(String playerId) {
    this.playerId = playerId;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public void setLastReadActivityId(String lastReadActivityId) {
    this.lastReadActivityId = lastReadActivityId;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("player_id", playerId);
    map.put("offset", offset);
    map.put("limit", limit);
    map.put("last_read_activity_id", lastReadActivityId);
    map.put("mode", mode);
    map.put("event_type", eventType);

    return map;
  }
}
