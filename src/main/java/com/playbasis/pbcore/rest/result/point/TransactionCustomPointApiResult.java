package com.playbasis.pbcore.rest.result.point;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.PBApiResult;

import java.util.List;

/**
 * Created by Nott on 18/11/2559.
 * playbasis-sdk-android-project
 */

public class TransactionCustomPointApiResult extends PBApiResult<List<TransactionCustomPointApiResult.Response>> {
  public static final String TAG = "TransactionCustomPointA";

  public class Response {
    @Expose
    @SerializedName("transaction_id")
    public String transactionId;
    @Expose
    @SerializedName("status")
    public String status;
  }
}
