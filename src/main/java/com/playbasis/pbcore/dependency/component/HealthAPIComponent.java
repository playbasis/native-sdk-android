package com.playbasis.pbcore.dependency.component;

import com.playbasis.pbcore.dependency.module.HealthModule;
import com.playbasis.sdk.HealthAPI;

import dagger.Component;

/**
 * Created by Tar on 8/19/16 AD.
 */
@PerActivity
@Component(dependencies = PlaybasisComponent.class,
    modules = { HealthModule.class })
public interface HealthAPIComponent {

  void inject(HealthAPI healthAPI);

}
