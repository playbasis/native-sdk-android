package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.result.organize.StoreOrganizeApiResult;
import com.playbasis.pbcore.rest.response.PlayerOrganizationResponse;

/**
 * Created by Tar on 6/9/16 AD.
 */
public abstract class Organization extends PBModel {

  protected String id;
  protected String name;
  protected String description;

  public Organization() {

  }

  public void init(PlayerOrganizationResponse playerOrganizationResponse) {
    this.id = playerOrganizationResponse.nodeId;
    this.name = playerOrganizationResponse.name;
  }

  public void init(StoreOrganizeApiResult.OrganizeResponse organizeResponse) {
    this.id = organizeResponse.id;
    this.name = organizeResponse.name;
    this.description = organizeResponse.description;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
