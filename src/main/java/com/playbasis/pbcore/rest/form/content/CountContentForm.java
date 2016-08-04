package com.playbasis.pbcore.rest.form.content;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class CountContentForm extends PBForm {

  public static final String TAG = "CountContentForm";

  protected String category = null;
  protected String playerId = null;
  protected String pin = null;

  public CountContentForm() {

  }

  @Override
  public ParamsMap getFields() {
    ParamsMap fields = super.getFields();

    fields.put("title", null);
    fields.put("category", category);
    fields.put("date_check", false);
    fields.put("pin", pin);
    fields.put("tags", null);
    fields.put("status", null);
    fields.put("player_id", playerId);
    fields.put("only_new_content", false);
    fields.put("only_new_feedback", false);

    return fields;
  }
}
