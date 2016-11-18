package com.playbasis.pbcore.domain.model;

import android.os.Parcel;

import com.playbasis.pbcore.rest.result.point.TransactionCustomPointApiResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nott on 18/11/2559.
 * playbasis-sdk-android-project
 */

public class Transaction extends PBModel {
  public static final String TAG = "Transaction";

  public String transactionId;
  public String success;

  public Transaction() {
  }

  public Transaction(String transactionId, String success) {
    this.transactionId = transactionId;
    this.success = success;
  }

  public String getSuccess() {
    return success;
  }

  public String getTransactionId() {
    return transactionId;
  }


  public static <T extends TransactionCustomPointApiResult.Response> ArrayList<Transaction> createTransactions(List<T> responses) {
    ArrayList<Transaction> remainingPoints = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return remainingPoints;
    }

    for (T response : responses) {
      remainingPoints.add(new Transaction(response.transactionId, response.status));
    }

    return remainingPoints;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.transactionId);
    dest.writeString(this.success);
  }

  protected Transaction(Parcel in) {
    this.transactionId = in.readString();
    this.success = in.readString();
  }

  public static final Creator<Transaction> CREATOR = new Creator<Transaction>() {
    @Override
    public Transaction createFromParcel(Parcel source) {
      return new Transaction(source);
    }

    @Override
    public Transaction[] newArray(int size) {
      return new Transaction[size];
    }
  };
}
