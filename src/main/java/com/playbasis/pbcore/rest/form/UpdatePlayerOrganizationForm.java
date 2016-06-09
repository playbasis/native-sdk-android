package com.playbasis.pbcore.rest.form;

import com.playbasis.pbcore.domain.model.Organization;

import java.util.List;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class UpdatePlayerOrganizationForm extends PBForm {

  private String playerId;
  private Organization newModel;
  private List<? extends Organization> currentModels;
  private boolean clearExising;

  public UpdatePlayerOrganizationForm(String playerId, Organization newModel, List<? extends Organization> currentModels, boolean clearExising) {
    this.playerId = playerId;
    this.newModel = newModel;
    this.currentModels = currentModels;
    this.clearExising = clearExising;
  }

  public String getPlayerId() {
    return playerId;
  }

  public Organization getNewModel() {
    return newModel;
  }

  public List<? extends Organization> getCurrentModels() {
    return currentModels;
  }

  public boolean shouldClearExising() {
    return clearExising;
  }
}
