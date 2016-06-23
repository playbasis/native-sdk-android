package com.playbasis.pbcore.rest.form.content;

import com.playbasis.pbcore.domain.model.Content;
import com.playbasis.pbcore.domain.model.Player;
import com.playbasis.pbcore.rest.form.content.ContentOpinionForm;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class DislikeContentForm extends ContentOpinionForm {

  public DislikeContentForm(Content content, Player player) {
    super(content, player);
  }
  
}
