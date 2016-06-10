package com.playbasis.pbcore.rest.result.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tar on 4/28/16 AD.
 */
public class PlayerOrganizationResponse {

  @SerializedName("node_id")
  public String nodeId;
  @SerializedName("name")
  public String name;
  @SerializedName("organize_type")
  public String organizationType;

}
