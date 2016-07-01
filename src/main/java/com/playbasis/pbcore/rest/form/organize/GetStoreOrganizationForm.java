package com.playbasis.pbcore.rest.form.organize;

import com.playbasis.pbcore.domain.model.Organization;

/**
 * Created by Tar on 6/10/16 AD.
 */
public class GetStoreOrganizationForm {

  protected String organizationId;
  protected Class<? extends Organization> klass;
  protected String saveKey = null;

  public GetStoreOrganizationForm(String organizationId, Class<? extends Organization> klass, boolean reloadCache) {
    this.organizationId = organizationId;
    this.klass = klass;
    this.saveKey = organizationId;
  }

  public String getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(String organizationId) {
    this.organizationId = organizationId;
  }

  public Class<? extends Organization> getKlass() {
    return klass;
  }

  public void setKlass(Class<? extends Organization> klass) {
    this.klass = klass;
  }

  public String getSaveKey() {
    return saveKey;
  }

  public void setSaveKey(String saveKey) {
    this.saveKey = saveKey;
  }
}
