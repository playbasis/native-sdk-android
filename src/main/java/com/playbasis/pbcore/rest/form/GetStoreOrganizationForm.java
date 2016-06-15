package com.playbasis.pbcore.rest.form;

import com.playbasis.pbcore.domain.model.Organization;

/**
 * Created by Tar on 6/10/16 AD.
 */
public class GetStoreOrganizationForm {

  protected String organizationId;
  protected Class<? extends Organization> klass;
  protected String saveKey = null;
  protected boolean reloadCache = false;

  public GetStoreOrganizationForm(String organizationId, Class<? extends Organization> klass, boolean reloadCache) {
    this.organizationId = organizationId;
    this.klass = klass;
    this.saveKey = organizationId;
    this.reloadCache = reloadCache;
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

  public boolean isReloadCache() {
    return reloadCache;
  }

  public void setReloadCache(boolean reloadCache) {
    this.reloadCache = reloadCache;
  }
}
