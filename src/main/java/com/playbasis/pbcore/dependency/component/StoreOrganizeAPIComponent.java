package com.playbasis.pbcore.dependency.component;

import com.playbasis.pbcore.dependency.module.OrganizationModule;
import com.playbasis.sdk.StoreOrganizeAPI;

import dagger.Component;

/**
 * Created by Tar on 8/19/16 AD.
 */
@PerActivity
@Component(dependencies = PlaybasisComponent.class,
    modules = { OrganizationModule.class })
public interface StoreOrganizeAPIComponent {

  void inject(StoreOrganizeAPI storeOrganizeAPI);

}
