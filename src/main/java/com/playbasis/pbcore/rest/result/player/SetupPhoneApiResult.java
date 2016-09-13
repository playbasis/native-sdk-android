package com.playbasis.pbcore.rest.result.player;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.PBApiResult;

/**
 * Created by Tar on 4/28/16 AD.
 */
public class SetupPhoneApiResult extends PBApiResult<SetupPhoneApiResult.Response> {

  public class Response {
    @SerializedName("to")
    public String to;
    @SerializedName("from")
    public String from;
    @SerializedName("message")
    public String message;
  }

}
