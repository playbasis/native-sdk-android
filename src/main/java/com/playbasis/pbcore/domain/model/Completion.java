package com.playbasis.pbcore.domain.model;

import android.os.Parcel;

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

  public static ArrayList<Completion> createCompletions(List<BaseMissionResponse.CompletionResponse> responses) {
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

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.elementId);
    dest.writeString(this.op);
    dest.writeString(this.filter);
    dest.writeString(this.value);
    dest.writeString(this.completionId);
    dest.writeString(this.type);
    dest.writeString(this.title);
    dest.writeParcelable(this.filteredParam, flags);
    dest.writeParcelable(this.completionData, flags);
  }

  protected Completion(Parcel in) {
    this.elementId = in.readString();
    this.op = in.readString();
    this.filter = in.readString();
    this.value = in.readString();
    this.completionId = in.readString();
    this.type = in.readString();
    this.title = in.readString();
    this.filteredParam = in.readParcelable(FilteredParam.class.getClassLoader());
    this.completionData = in.readParcelable(CompletionData.class.getClassLoader());
  }

  public static final Creator<Completion> CREATOR = new Creator<Completion>() {
    @Override
    public Completion createFromParcel(Parcel source) {
      return new Completion(source);
    }

    @Override
    public Completion[] newArray(int size) {
      return new Completion[size];
    }
  };

  public static class FilteredParam extends PBModel {

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

    public static class Quantity extends PBModel {

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

      @Override
      public int describeContents() {
        return 0;
      }

      @Override
      public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.operation);
        dest.writeString(this.completionString);
      }

      protected Quantity(Parcel in) {
        this.operation = in.readString();
        this.completionString = in.readString();
      }

      public static final Creator<Quantity> CREATOR = new Creator<Quantity>() {
        @Override
        public Quantity createFromParcel(Parcel source) {
          return new Quantity(source);
        }

        @Override
        public Quantity[] newArray(int size) {
          return new Quantity[size];
        }
      };
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeParcelable(this.quantity, flags);
    }

    protected FilteredParam(Parcel in) {
      this.quantity = in.readParcelable(Quantity.class.getClassLoader());
    }

    public static final Creator<FilteredParam> CREATOR = new Creator<FilteredParam>() {
      @Override
      public FilteredParam createFromParcel(Parcel source) {
        return new FilteredParam(source);
      }

      @Override
      public FilteredParam[] newArray(int size) {
        return new FilteredParam[size];
      }
    };
  }

  public static class CompletionData extends PBModel {

    protected String actionId;
    protected String name;
    protected String description;
    protected String icon;
    protected String color;

    private CompletionData(BaseMissionResponse.CompletionResponse.CompletionDataResponse completionDataResponse) {
      if (completionDataResponse == null) {
        return;
      }

      this.actionId = completionDataResponse.actionId;
      this.name = completionDataResponse.name;
      this.description = completionDataResponse.description;
      this.icon = completionDataResponse.icon;
      this.color = completionDataResponse.color;
    }

    public String getActionId() {
      return actionId;
    }

    public String getName() {
      return name;
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

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.actionId);
      dest.writeString(this.name);
      dest.writeString(this.description);
      dest.writeString(this.icon);
      dest.writeString(this.color);
    }

    protected CompletionData(Parcel in) {
      this.actionId = in.readString();
      this.name = in.readString();
      this.description = in.readString();
      this.icon = in.readString();
      this.color = in.readString();
    }

    public static final Creator<CompletionData> CREATOR = new Creator<CompletionData>() {
      @Override
      public CompletionData createFromParcel(Parcel source) {
        return new CompletionData(source);
      }

      @Override
      public CompletionData[] newArray(int size) {
        return new CompletionData[size];
      }
    };
  }
}
