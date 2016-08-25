package com.playbasis.pbcore.dependency.component;

import com.playbasis.pbcore.dependency.module.EngineModule;
import com.playbasis.sdk.EngineAPI;

import dagger.Component;

/**
 * Created by Tar on 8/19/16 AD.
 */
@PerActivity
@Component(dependencies = PlaybasisComponent.class,
    modules = { EngineModule.class })
public interface EngineAPIComponent {

  void inject(EngineAPI engineAPI);

}
