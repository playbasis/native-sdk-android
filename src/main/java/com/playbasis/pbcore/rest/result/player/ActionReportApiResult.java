package com.playbasis.pbcore.rest.result.player;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.PBApiResult;

import java.util.HashMap;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class ActionReportApiResult extends PBApiResult<HashMap<String, HashMap<String, ActionReportApiResult.Response>>> {

  public class Response {

    @SerializedName("quantity")
    public int quantity;
    @SerializedName("previous_quantity")
    public int previousQuantity;
    @SerializedName("percent_changed")
    public int percentChanged;
  }
}
