package com.playbasis.pbcore.domain.model.modelInterface;

import com.playbasis.pbcore.rest.result.response.OrganizeResponse;

/**
 * Created by Tar on 4/29/16 AD.
 */
public interface OrganizableModel {

  String getOrganizeId();

  void updateByOrganize(OrganizeResponse organizeResponse);

}
