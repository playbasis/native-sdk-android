package com.playbasis.pbcore.dependency.component;

import com.playbasis.pbcore.dependency.module.MerchantModule;
import com.playbasis.sdk.MerchantAPI;

import dagger.Component;

/**
 * Created by Tar on 8/19/16 AD.
 */
@PerActivity
@Component(dependencies = PlaybasisComponent.class,
    modules = { MerchantModule.class })
public interface MerchantAPIComponent {

  void inject(MerchantAPI merchantAPI);

}
