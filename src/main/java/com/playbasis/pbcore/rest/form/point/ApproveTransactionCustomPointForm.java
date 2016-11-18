package com.playbasis.pbcore.rest.form.point;

import java.util.List;

/**
 * Created by Nott on 17/11/2559.
 * DBS-SDK
 */

public class ApproveTransactionCustomPointForm {
  public static final String TAG = "RetrieveRemainingPoints";

  public String transaction;
  public String isApprove;

  public String getIsApprove() {
    return isApprove;
  }

  public String getTransaction() {
    return transaction;
  }

  public void setIsApprove(boolean isApprove) {
    this.isApprove = isApprove ? "true" : "false";
  }

  public void setTransaction(String transaction) {
    this.transaction = transaction;
  }

  public void setTransaction(List<String> transactions) {
    for (int i = 0; i < transactions.size(); i++) {
      transaction += transactions.get(i);
    }
  }
}
