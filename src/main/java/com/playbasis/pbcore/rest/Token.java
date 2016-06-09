package com.playbasis.pbcore.rest;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class Token implements Parcelable {

  @SerializedName("token")
  public String token;
  @SerializedName("date_expire")
  public Date expiredDate;

  protected Token(Parcel in) {
    token = in.readString();
    expiredDate = new Date(in.readLong());
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(token);
    dest.writeLong(expiredDate.getTime());
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<Token> CREATOR = new Creator<Token>() {
    @Override
    public Token createFromParcel(Parcel in) {
      return new Token(in);
    }

    @Override
    public Token[] newArray(int size) {
      return new Token[size];
    }
  };
}
