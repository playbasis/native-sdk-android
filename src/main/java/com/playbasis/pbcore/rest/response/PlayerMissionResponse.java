package com.playbasis.pbcore.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tar on 5/5/16 AD.
 */
public class PlayerMissionResponse extends BaseMissionResponse {

  @Expose
  @SerializedName("status")
  public String status;
  @Expose
  @SerializedName("pending")
  public List<PendingResponse> pendingResponses;

  public List<PendingResponse> getPendingResponses() {
    if (pendingResponses != null) {
      return pendingResponses;
    }

    return new ArrayList<>();
  }

  public class PendingResponse {

    @Expose
    @SerializedName("event_type")
    public String eventType;
    @Expose
    @SerializedName("message")
    public String message;
    @Expose
    @SerializedName("incomplete")
    public IncompletionResponse incompletionResponse;

    public class IncompletionResponse {

      @Expose
      @SerializedName("incompletion_id")
      public String incompletionId;
      @Expose
      @SerializedName("incompletion_type")
      public String type;
      @Expose
      @SerializedName("incompletion_value")
      public String value;
      @Expose
      @SerializedName("incompletion_element_id")
      public String elementId;
      @Expose
      @SerializedName("incompletion_filter")
      public String filter;
    }
  }
}
