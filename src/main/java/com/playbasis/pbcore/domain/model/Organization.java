package com.playbasis.pbcore.domain.model;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.domain.model.PBModel;
import com.playbasis.pbcore.domain.model.modelInterface.OrganizableModel;
import com.playbasis.pbcore.rest.result.response.OrganizeResponse;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class Organization extends PBModel implements OrganizableModel {

  @SerializedName("_id")
  public String id;
  @SerializedName("name")
  public String name;
  @SerializedName("description")
  public String description;

  @Override
  public String getOrganizeId() {
    return id;
  }

  @Override
  public void updateByOrganize(OrganizeResponse organizeResponse) {
    this.id = organizeResponse.nodeId;
    this.name = organizeResponse.name;
  }
}
