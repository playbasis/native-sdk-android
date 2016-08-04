package com.playbasis.pbcore.rest.form.organize;

import com.playbasis.pbcore.domain.model.Organization;
import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 6/10/16 AD.
 */
public class GetStoreOrganizationForm extends PBForm {

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

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("id", null);
    map.put("organize_id", organizationId);
    map.put("parent_id", null);
    map.put("search", null);
    map.put("sort", null);
    map.put("order", "asc");
    map.put("offset", 0);
    map.put("limit", 100);

    return map;
  }
}
