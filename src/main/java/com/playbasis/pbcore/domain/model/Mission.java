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

  public static <T extends BaseMissionResponse> ArrayList<Mission> create(List<T> responses) {
    ArrayList<Mission> missions = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return missions;
    }

    for (int i = 0; i < responses.size(); i++) {
      T response = responses.get(i);
      Mission mission = new Mission();

      if (response instanceof MissionResponse) {
        mission.init((MissionResponse) response);
      } else if (response instanceof PlayerMissionResponse) {
        mission.init((PlayerMissionResponse) response);
      }

      missions.add(mission);
    }

    return missions;
  }

  private void setup(BaseMissionResponse response, boolean allowNull) {
    this.missionId = valueOrDefault(response.missionId, this.missionId);
    this.questId = valueOrDefault(response.questId, this.questId);
    this.name = valueOrDefault(response.name, this.name, allowNull);
    this.number = valueOrDefault(response.number, this.number, allowNull);
    this.description = valueOrDefault(response.description, this.description, allowNull);
    this.hint = valueOrDefault(response.hint, this.hint, allowNull);
    this.imageUrl = valueOrDefault(response.imageUrl, this.imageUrl, allowNull);
    this.completions = valueOrDefault(Completion.create(response.completionResponse), this.completions, allowNull);
  }

  public void init(MissionResponse response) {
    init(response, true);
  }

  public void init(MissionResponse response, boolean allowNull) {
    if (response == null) {
      return;
    }

    setup(response, allowNull);
  }

  public void init(PlayerMissionResponse response) {
    init(response, true);
  }

  public void init(PlayerMissionResponse response, boolean allowNull) {
    if (response == null) {
      return;
    }

    setup(response, allowNull);

    this.status = valueOrDefault(response.status, this.status, allowNull);

    if (allowNull && response.getPendingResponses().size() == 0) {
      this.pendings = null;
    } else {
      this.pendings = new ArrayList<>();

      for (PlayerMissionResponse.PendingResponse pendingResponse : response.getPendingResponses()) {
        this.pendings.add(new Pending(pendingResponse));
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
