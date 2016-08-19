package com.playbasis.pbcore.dependency.component;

import com.playbasis.pbcore.dependency.module.RedeemModule;
import com.playbasis.sdk.RedeemAPI;

import dagger.Component;

/**
 * Created by Tar on 8/19/16 AD.
 */
@PerActivity
@Component(dependencies = PlaybasisComponent.class,
    modules = { RedeemModule.class })
public interface RedeemAPIComponent {

  void inject(RedeemAPI redeemAPI);

}
