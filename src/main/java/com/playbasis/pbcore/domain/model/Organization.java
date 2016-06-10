package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.result.StoreOrganizeApiResult;
import com.playbasis.pbcore.rest.result.response.PlayerOrganizationResponse;

/**
 * Created by Tar on 6/9/16 AD.
 */
public abstract class Organization extends PBModel {

  public String id;
  public String name;
  public String description;

  public void init(PlayerOrganizationResponse playerOrganizationResponse) {
    this.id = playerOrganizationResponse.nodeId;
    this.name = playerOrganizationResponse.name;
  }

  public void init(StoreOrganizeApiResult.OrganizeResponse organizeResponse) {
    this.id = organizeResponse.id;
    this.name = organizeResponse.name;
    this.description = organizeResponse.description;
  }

  public String getOrganizeId() {
    return id;
  }
}
