package com.playbasis.pbcore.rest.form.organize;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 6/10/16 AD.
 */
public class GetStoreOrganizationForm extends PBForm {

  protected String organizationId;

  public GetStoreOrganizationForm() {

  }

  public void setOrganizationId(String organizationId) {
    this.organizationId = organizationId;
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
