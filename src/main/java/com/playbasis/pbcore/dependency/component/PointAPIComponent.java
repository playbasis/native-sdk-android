package com.playbasis.pbcore.dependency.component;

import com.playbasis.pbcore.dependency.module.PointModule;
import com.playbasis.sdk.PointAPI;

import dagger.Component;

/**
 * Created by Nott on 17/11/16 AD.
 * PointAPIComponent
 */
@PerActivity
@Component(dependencies = PlaybasisComponent.class,
    modules = {PointModule.class})
public interface PointAPIComponent {

  void inject(PointAPI pointAPI);

}
