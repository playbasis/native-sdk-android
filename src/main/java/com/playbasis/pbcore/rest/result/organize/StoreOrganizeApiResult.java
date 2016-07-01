package com.playbasis.pbcore.rest.result.organize;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.response.OrganizeResponse;
import com.playbasis.pbcore.rest.result.PBApiResult;

import java.util.List;

/**
 * Created by Tar on 4/26/16 AD.
 */
public class StoreOrganizeApiResult extends PBApiResult<StoreOrganizeApiResult.Response> {

  public List<OrganizeResponse> getOrganizationResponse() {
    return response.organizations;
  }

  public class Response {

    @SerializedName("results")
    public List<OrganizeResponse> organizations;

  }

}
