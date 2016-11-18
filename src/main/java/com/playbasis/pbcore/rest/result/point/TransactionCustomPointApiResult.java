package com.playbasis.pbcore.rest.result.point;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nott on 18/11/2559.
 * playbasis-sdk-android-project
 */

public class TransactionCustomPointApiResult {

  public class Response {
    @Expose
    @SerializedName("transaction_id")
    public String transactionId;
    @Expose
    @SerializedName("status")
    public String status;

  }
}
