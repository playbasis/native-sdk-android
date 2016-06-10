package com.playbasis.pbcore.rest.result;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.domain.model.Organization;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tar on 4/26/16 AD.
 */
public class StoreOrganizeApiResult extends PBApiResult<StoreOrganizeApiResult.Response> {

  public List<OrganizeResponse> getOrganizationResponse() {
    return response.organizations;
  }

  public <T extends Organization> List<T> getOrganizations(Class<T> klass) {
    List<T> results = new ArrayList<>();

    for (OrganizeResponse organizeResponse : response.organizations) {
      try {
        T t = klass.newInstance();
        t.init(organizeResponse);
        results.add(t);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    return results;
  }

  public class Response {

    @SerializedName("results")
    public List<OrganizeResponse> organizations;

  }

  public class OrganizeResponse {

    @SerializedName("_id")
    public String id;
    @SerializedName("name")
    public String name;
    @SerializedName("description")
    public String description;

  }

}
