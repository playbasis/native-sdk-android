package com.playbasis.pbcore.rest.form;

import com.playbasis.pbcore.domain.model.Organization;

import java.util.List;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class UpdatePlayerOrganizationForm extends PBForm {

  protected String playerId;
  protected Organization newModel;
  protected List<? extends Organization> currentModels;
  protected boolean clearExising;

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

  public void setNewModel(Organization newModel) {
    this.newModel = newModel;
  }

  public List<? extends Organization> getCurrentModels() {
    return currentModels;
  }

  public void setCurrentModels(List<? extends Organization> currentModels) {
    this.currentModels = currentModels;
  }

  public boolean isClearExising() {
    return clearExising;
  }

  public void setClearExising(boolean clearExising) {
    this.clearExising = clearExising;
  }
}
