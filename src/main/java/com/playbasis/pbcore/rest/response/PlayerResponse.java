package com.playbasis.pbcore.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.domain.model.Birthdate;

import java.util.List;

/**
 * Created by androiddev01 on 4/26/2016 AD.
 */
public class PlayerResponse {
  public static final String TAG = "PlayerResponse";

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
  public String playerId;
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
  @SerializedName("percent_of_level")
  public float levelPercent;
  @Expose
  @SerializedName("level_title")
  public String levelTitle;
  @Expose
  @SerializedName("level_image")
  public String levelImageUrl;
  @Expose
  @SerializedName("organization")
  public List<PlayerOrganizationResponse> playerOrganizationResponses;
  @Expose
  @SerializedName("badges")
  public List<BadgeResponse> playerBadgesResponses;
  @SerializedName("goods")
  public List<GoodsResponse> playerGoodsResponses;

  public PlayerResponse() {

  }
}
