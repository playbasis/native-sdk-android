package com.playbasis.pbcore.rest.result.response;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

/**
 * Created by androiddev01 on 5/12/2016 AD.
 */
public class PlayerResponse {
  public static final String TAG = "PlayerResponse";

  @SerializedName("custom")
  public HashMap<String, String> customFieldMap;

}
