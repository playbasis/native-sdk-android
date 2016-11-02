package com.playbasis.pbcore.dependency.component;

import com.playbasis.pbcore.dependency.module.GenericModule;
import com.playbasis.sdk.GenericAPI;

import dagger.Component;

/**
 * Created by Tar on 8/19/16 AD.
 */
@PerActivity
@Component(dependencies = PlaybasisComponent.class,
    modules = { GenericModule.class })
public interface GenericAPIComponent {

  void inject(GenericAPI genericAPI);

}
