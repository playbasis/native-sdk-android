package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.response.BaseMissionResponse;
import com.playbasis.pbcore.rest.response.MissionResponse;
import com.playbasis.pbcore.rest.response.PlayerMissionResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tar on 6/22/16 AD.
 */
public class Mission extends PBModel {

  protected String missionId;
  protected String questId;
  protected String name;
  protected String number;
  protected String description;
  protected String hint;
  protected String imageUrl;
  protected List<Completion> completions;
  protected String status;
  protected List<Pending> pendings;

  public Mission() {

  }

  public Mission(BaseMissionResponse response) {
    update(response);
  }

  public static <T extends BaseMissionResponse> ArrayList<Mission> create(List<T> responses) {
    ArrayList<Mission> missions = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return missions;
    }

    for (int i = 0; i < responses.size(); i++) {
      T response = responses.get(i);
      if (response instanceof MissionResponse) {
        missions.add(new Mission((MissionResponse) response));
      } else if (response instanceof PlayerMissionResponse) {
        missions.add(new Mission((PlayerMissionResponse) response));
      }
    }

    return missions;
  }

  public void update(BaseMissionResponse response) {
    if (response == null) {
      return;
    }

    this.missionId = valueOrDefault(response.missionId, missionId);
    this.questId = response.questId;
    this.name = response.name;
    this.number = response.number;
    this.description = response.description;
    this.hint = response.hint;
    this.imageUrl = response.imageUrl;
    this.completions = Completion.create(response.completionResponse);

    if (response instanceof PlayerMissionResponse) {
      PlayerMissionResponse playerMissionResponse = (PlayerMissionResponse) response;

      this.status = playerMissionResponse.status;

      if (playerMissionResponse.getPendingResponses().size() == 0) {
        this.pendings = null;
      } else {
        this.pendings = new ArrayList<>();

        for (PlayerMissionResponse.PendingResponse pendingResponse : playerMissionResponse.getPendingResponses()) {
          this.pendings.add(new Pending(pendingResponse));
        }
      }
    }
  }

  public String getMissionId() {
    return missionId;
  }

  public String getQuestId() {
    return questId;
  }

  public String getName() {
    return name;
  }

  public String getNumber() {
    return number;
  }

  public String getDescription() {
    return description;
  }

  public String getHint() {
    return hint;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public static class Pending {

    protected String eventType;
    protected String message;
    protected Incompletion incompletion;

    public Pending(PlayerMissionResponse.PendingResponse pendingResponse) {
      if (pendingResponse == null) {
        return;
      }

      this.eventType = pendingResponse.eventType;
      this.message = pendingResponse.message;
      this.incompletion = new Incompletion(pendingResponse.incompletionResponse);
    }

    public String getEventType() {
      return eventType;
    }

    public String getMessage() {
      return message;
    }

    public Incompletion getIncompletion() {
      return incompletion;
    }

    public static class Incompletion {

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
  }
}
