package com.playbasis.sdk;

import com.playbasis.pbcore.dependency.component.DaggerStoreOrganizeAPIComponent;
import com.playbasis.pbcore.dependency.module.OrganizationModule;
import com.playbasis.pbcore.domain.interactor.organize.GetOrganizationInteractor;

import javax.inject.Inject;

/**
 * Created by Tar on 8/19/16 AD.
 */
public class StoreOrganizeAPI {

  private static StoreOrganizeAPI storeOrganizeAPI;

  @Inject
  protected GetOrganizationInteractor getOrganizationInteractor;

  public static StoreOrganizeAPI instance() {
    if (storeOrganizeAPI == null) {
      storeOrganizeAPI = new StoreOrganizeAPI();

      DaggerStoreOrganizeAPIComponent.builder()
          .playbasisComponent(Playbasis.getPlaybasisComponent())
          .organizationModule(new OrganizationModule())
          .build()
          .inject(storeOrganizeAPI);
    }

    return storeOrganizeAPI;
  }
}
