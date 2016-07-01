package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.response.OrganizeResponse;
import com.playbasis.pbcore.rest.response.PlayerOrganizationResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class Organization extends PBModel {

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

  public static ArrayList<Organization> createOrganizes(List<OrganizeResponse> responses) {
    ArrayList<Organization> organizations = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return organizations;
    }

    for (OrganizeResponse organizeResponse : responses) {
      organizations.add(new Organization(organizeResponse));
    }

    return organizations;
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
