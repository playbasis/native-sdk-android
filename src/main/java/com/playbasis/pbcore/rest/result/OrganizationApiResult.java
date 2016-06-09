package com.playbasis.pbcore.rest.result;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.domain.model.Organization;

import java.util.List;

/**
 * Created by Tar on 4/26/16 AD.
 */
public class OrganizationApiResult<T extends Organization> extends PBApiResult<OrganizationApiResult.Response> {

  public List<T> getOrganizations() {
    return response.organizations;
  }

  public class Response {

    @SerializedName("results")
    public List<T> organizations;
  }

}
