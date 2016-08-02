package com.playbasis.pbcore.rest.response;

import java.util.HashMap;

/**
 * Created by Tar on 7/26/16 AD.
 */
public class PlayerRankResponse {

  public String playerId;
  public String sortBy;
  public int value;

  public static class PlayerRankHashMap extends HashMap<String, String> {

  }
}
