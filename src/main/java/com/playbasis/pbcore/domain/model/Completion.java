package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.response.BaseMissionResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tar on 6/22/16 AD.
 */
public class Completion extends PBModel {

  protected String elementId;
  protected String op;
  protected String filter;
  protected String value;
  protected String completionId;
  protected String type;
  protected String title;
  protected FilteredParam filteredParam;
  protected CompletionData completionData;

  public Completion() {

  }

  public Completion(BaseMissionResponse.CompletionResponse response) {
    update(response);
  }

  public static ArrayList<Completion> create(List<BaseMissionResponse.CompletionResponse> responses) {
    ArrayList<Completion> completions = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return completions;
    }

    for (BaseMissionResponse.CompletionResponse completionResponse : responses) {
      completions.add(new Completion(completionResponse));
    }

    return completions;
  }

  public void update(BaseMissionResponse.CompletionResponse response) {
    if (response == null) {
      return;
    }

    this.elementId = valueOrDefault(response.elementId, elementId);
    this.op = response.op;
    this.filter = response.filter;
    this.value = response.value;
    this.completionId = response.completionId;
    this.type = response.type;
    this.title = response.title;
    this.filteredParam = new FilteredParam(response.filteredParamResponse);
    this.completionData = new CompletionData(response.completionDataResponse);
  }

  public String getElementId() {
    return elementId;
  }

  public String getOp() {
    return op;
  }

  public String getFilter() {
    return filter;
  }

  public String getValue() {
    return value;
  }

  public String getCompletionId() {
    return completionId;
  }

  public String getType() {
    return type;
  }

  public String getTitle() {
    return title;
  }

  public FilteredParam getFilteredParam() {
    return filteredParam;
  }

  public CompletionData getCompletionData() {
    return completionData;
  }

  public static class FilteredParam {

    protected Quantity quantity;

    private FilteredParam(BaseMissionResponse.CompletionResponse.FilteredParamResponse filteredParamResponse) {
      if (filteredParamResponse == null) {
        return;
      }

      this.quantity = new Quantity(filteredParamResponse.quantityResponse);
    }

    public Quantity getQuantity() {
      return quantity;
    }

    public static class Quantity {

      protected String operation;
      protected String completionString;

      private Quantity(BaseMissionResponse.CompletionResponse.FilteredParamResponse.QuantityResponse quantityResponse) {
        if (quantityResponse == null) {
          return;
        }

        this.operation = quantityResponse.operation;
        this.completionString = quantityResponse.completionString;
      }

      public String getOperation() {
        return operation;
      }

      public String getCompletionString() {
        return completionString;
      }
    }
  }

  public static class CompletionData {

    protected String actionId;
    protected String step;
    protected String description;
    protected String icon;
    protected String color;

    private CompletionData(BaseMissionResponse.CompletionResponse.CompletionDataResponse completionDataResponse) {
      if (completionDataResponse == null) {
        return;
      }

      this.actionId = completionDataResponse.actionId;
      this.step = completionDataResponse.step;
      this.description = completionDataResponse.description;
      this.icon = completionDataResponse.icon;
      this.color = completionDataResponse.color;
    }

    public String getActionId() {
      return actionId;
    }

    public String getStep() {
      return step;
    }

    public String getDescription() {
      return description;
    }

    public String getIcon() {
      return icon;
    }

    public String getColor() {
      return color;
    }
  }

}
