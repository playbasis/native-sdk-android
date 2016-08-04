package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 6/10/16 AD.
 */
public class GetPlayerBadgesForm extends PBForm {

  public String playerId;

  public GetPlayerBadgesForm(String playerId) {
    this.playerId = playerId;
  }

  public String getPlayerId() {
    return playerId;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("tags", null);

    return map;
  }
}
