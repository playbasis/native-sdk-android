package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.response.OrganizeResponse;
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

  public Organization(PlayerOrganizationResponse response) {
    update(response);
  }

  public Organization(OrganizeResponse response) {
    update(response);
  }

  public void update(PlayerOrganizationResponse response) {
    if (response == null) {
      return;
    }

    this.id = valueOrDefault(response.nodeId, id);
    this.name = response.name;
  }

  public void update(OrganizeResponse response) {
    if (response == null) {
      return;
    }

    this.id = valueOrDefault(response.id, id);
    this.name = response.name;
    this.description = response.description;
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
