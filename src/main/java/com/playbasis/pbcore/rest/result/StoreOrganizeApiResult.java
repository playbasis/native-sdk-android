package com.playbasis.pbcore.rest.result;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.domain.model.Organization;

import java.util.List;

/**
 * Created by Tar on 4/26/16 AD.
 */
public class StoreOrganizeApiResult extends PBApiResult<StoreOrganizeApiResult.Response> {

  public List<Organization> getOrganizations() {
    return response.organizations;
  }

  public class Response {

    @SerializedName("results")
    public List<Organization> organizations;
  }

}
