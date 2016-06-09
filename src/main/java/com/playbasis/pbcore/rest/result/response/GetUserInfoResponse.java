package com.playbasis.pbcore.rest.result.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.domain.model.Birthdate;
import com.playbasis.pbcore.domain.model.Organize;

import java.util.List;

/**
 * Created by androiddev01 on 4/26/2016 AD.
 */
public class GetUserInfoResponse {
  public static final String TAG = "GetUserInfoResponse";

  @Expose
  @SerializedName("image")
  public String image;
  @Expose
  @SerializedName("email")
  public  String email;
  @Expose
  @SerializedName("username")
  public  String userName;
  @Expose
  @SerializedName("first_name")
  public String firstName;
  @Expose
  @SerializedName("last_name")
  public String lastName;
  @Expose
  @SerializedName("gender")
  public int gender;
  @Expose
  @SerializedName("birth_date")
  public Birthdate birthdate;
  @Expose
  @SerializedName("cl_player_id")
  public String userId;
  @Expose
  @SerializedName("phone_number")
  public String phoneNumber;
  @Expose
  @SerializedName("registered")
  public String registered;
  @Expose
  @SerializedName("last_login")
  public String lastLogin;
  @Expose
  @SerializedName("last_logout")
  public String lastLogout;
  @Expose
  @SerializedName("organization")
  public List<Organize> organizes;

  public GetUserInfoResponse() {

  }
}
