package com.playbasis.pbcore.rest.form;

import com.playbasis.pbcore.domain.model.Organization;

/**
 * Created by Tar on 6/10/16 AD.
 */
public class GetStoreOrganizationForm {

  public String organizationId;
  public Class<? extends Organization> klass;
  public String saveKey = null;
  public boolean reloadCache = false;

  public GetStoreOrganizationForm(String organizationId, Class<? extends Organization> klass, boolean reloadCache) {
    this.organizationId = organizationId;
    this.klass = klass;
    this.saveKey = organizationId;
    this.reloadCache = reloadCache;
  }
}
