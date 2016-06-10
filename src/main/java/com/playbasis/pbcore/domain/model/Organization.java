package com.playbasis.pbcore.domain.model;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.response.PlayerOrganizationResponse;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class Organization extends PBModel {

  @SerializedName("_id")
  public String id;
  @SerializedName("name")
  public String name;
  @SerializedName("description")
  public String description;

  public Organization(PlayerOrganizationResponse playerOrganizationResponse) {
    this.id = playerOrganizationResponse.nodeId;
    this.name = playerOrganizationResponse.name;
  }

  public String getOrganizeId() {
    return id;
  }
}
