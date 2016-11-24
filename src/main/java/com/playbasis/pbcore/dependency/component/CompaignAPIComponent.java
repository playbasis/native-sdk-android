package com.playbasis.pbcore.dependency.component;

import com.playbasis.pbcore.dependency.module.CampaignModule;
import com.playbasis.sdk.CampaignAPI;

import dagger.Component;

/**
 * Created by Tar on 8/19/16 AD.
 */
@PerActivity
@Component(dependencies = PlaybasisComponent.class,
    modules = {CampaignModule.class})
public interface CompaignAPIComponent {

  void inject(CampaignAPI campaignAPI);

}
