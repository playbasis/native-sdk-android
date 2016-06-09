package com.playbasis.pbcore.domain.model;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.response.OrganizeResponse;

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

  public Organization(OrganizeResponse organizeResponse) {
    this.id = organizeResponse.nodeId;
    this.name = organizeResponse.name;
  }

  public String getOrganizeId() {
    return id;
  }
}
