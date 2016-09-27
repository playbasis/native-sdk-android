package com.playbasis.pbcore.dependency.component;

import com.playbasis.pbcore.dependency.module.GameModule;
import com.playbasis.sdk.FileAPI;
import com.playbasis.sdk.GameAPI;

import dagger.Component;

/**
 * Created by Tar on 8/19/16 AD.
 */
@PerActivity
@Component(dependencies = PlaybasisComponent.class,
    modules = { GameModule.class })
public interface GameAPIComponent {

  void inject(GameAPI gameAPI);

}
