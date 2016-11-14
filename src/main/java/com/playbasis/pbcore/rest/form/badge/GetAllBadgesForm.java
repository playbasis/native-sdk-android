package com.playbasis.pbcore.rest.form.badge;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 6/10/16 AD.
 */
public class GetAllBadgesForm extends PBForm {

  public String tags = null;

  public GetAllBadgesForm() {

  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("tags", tags);

    return map;
  }

  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }
}
