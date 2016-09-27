package com.playbasis.pbcore.dependency.component;

import com.playbasis.pbcore.dependency.module.TripModule;
import com.playbasis.sdk.TripAPI;

import dagger.Component;

/**
 * Created by Tar on 8/19/16 AD.
 */
@PerActivity
@Component(dependencies = PlaybasisComponent.class,
    modules = { TripModule.class })
public interface TripAPIComponent {

  void inject(TripAPI tripAPI);

}
