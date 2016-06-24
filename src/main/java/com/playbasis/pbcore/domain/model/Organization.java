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

  public void init(PlayerOrganizationResponse response) {
    init(response);
  }

  public void init(PlayerOrganizationResponse response, boolean allowNull) {
    if (response == null) {
      return;
    }

    this.id = valueOrDefault(response.nodeId, this.id);
    this.name = valueOrDefault(response.name, this.name, allowNull);
  }

  public void init(OrganizeResponse response) {
    init(response);
  }

  public void init(OrganizeResponse response, boolean allowNull) {
    if (response == null) {
      return;
    }

    this.id = valueOrDefault(response.id, this.id);
    this.name = valueOrDefault(response.name, this.name, allowNull);
    this.description = valueOrDefault(response.description, this.description, allowNull);
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
