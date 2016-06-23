package com.playbasis.pbcore.rest.response;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

/**
 * Created by androiddev01 on 5/12/2016 AD.
 */
public class PlayerCustomFieldResponse {
  public static final String TAG = "PlayerCustomFieldResponse";

  @SerializedName("custom")
  public HashMap<String, String> customFieldMap;

}
